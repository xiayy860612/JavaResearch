package com.s2u2m.javaresearch.lucene.basic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

/**
 * Searcher
 * Create by Yangyang.xia on 8/30/18
 */
public class Searcher {

    private IndexReader indexReader;

    public Searcher(String indexDir) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(indexDir));
        indexReader = DirectoryReader.open(directory);
    }

    public List<String> getFilePaths(String key) {
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        return new ArrayList<>();
    }

}
