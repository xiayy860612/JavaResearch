package com.s2u2m.javaresearch.lucene.basic;

import java.io.IOException;
import java.net.URL;

/**
 * LuceneBasicMain
 * Create by Yangyang.xia on 8/29/18
 */
public class LuceneBasicMain {

    public static void main(String[] args) throws IOException {
        URL dataSrcDir = LuceneBasicMain.class.getClassLoader().getResource("data_src");
        URL indexDir = LuceneBasicMain.class.getClassLoader().getResource("index");

        Indexer indexer = new Indexer(indexDir.getPath());
        indexer.index(dataSrcDir.getPath());

        System.out.println("Done");
    }
}
