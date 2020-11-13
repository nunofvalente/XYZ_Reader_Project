package com.example.xyzreader;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ArticleExecutor {

    private static final Object LOCK = new Object();
    private static ArticleExecutor eInstance;
    private final Executor databaseExecutor;

    private ArticleExecutor(Executor databaseExecutor) {
        this.databaseExecutor = databaseExecutor;
    }

    public static ArticleExecutor getInstance() {
        if(eInstance == null) {
            synchronized (LOCK) {
                eInstance = new ArticleExecutor(Executors.newSingleThreadExecutor());
            }
        }
        return eInstance;
    }

    public Executor getDatabaseExecutor() {
        return databaseExecutor;
    }
}
