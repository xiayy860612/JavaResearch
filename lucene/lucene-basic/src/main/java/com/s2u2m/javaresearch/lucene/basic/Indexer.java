package com.s2u2m.javaresearch.lucene.basic;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

/**
 * Indexer
 * Create by Yangyang.xia on 8/29/18
 */
public class Indexer {

    private String indexDir;
    private IndexWriter indexWriter;

    public Indexer(String indexDir) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(indexDir));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        indexWriter = new IndexWriter(directory, iwc);
    }

    public int index(String dataDir) throws IOException {
        Path path = Paths.get(dataDir);
        if (!Files.isDirectory(path)) {
            indexFile(path);
            return indexWriter.numDocs();
        }

        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                try {
                    indexFile(file);
                } catch (IOException ex) {
                    // ignore
                    ex.printStackTrace();
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(path, visitor);
        return indexWriter.numDocs();
    }

    private void indexFile(Path filePath) throws IOException {
        Document doc = getDocument(filePath);
        indexWriter.addDocument(doc);
    }

    private Document getDocument(Path filePath) {
        Document document = new Document();

        Field pathField = new StringField("path", filePath.toString(), Field.Store.YES);
        document.add(pathField);

        return document;
    }
}
