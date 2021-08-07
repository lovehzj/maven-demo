package com.github.shoothzj.demo.caffeine;

import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author hezhangjian
 */
@Slf4j
public class CaffeineDemo {

    private final AsyncLoadingCache<String, List<String>> childrenCache;

    public CaffeineDemo() {
        this.childrenCache = Caffeine.newBuilder()
                .refreshAfterWrite(600, TimeUnit.SECONDS)
                .buildAsync(new AsyncCacheLoader<String, List<String>>() {
                    @Override
                    public CompletableFuture<List<String>> asyncLoad(String key, Executor executor) {
                        CompletableFuture<List<String>> future = new CompletableFuture<>();
                        future.complete(new ArrayList<>());
                        return future;
                    }

                    @Override
                    public CompletableFuture<List<String>> asyncReload(String key, List<String> oldValue,
                                                                       Executor executor) {
                        CompletableFuture<List<String>> future = new CompletableFuture<>();
                        future.complete(new ArrayList<>());
                        return future;
                    }
                });
    }
}
