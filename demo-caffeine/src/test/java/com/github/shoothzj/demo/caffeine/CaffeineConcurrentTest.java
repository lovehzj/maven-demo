package com.github.shoothzj.demo.caffeine;

import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.shoothzj.javatool.util.CommonUtil;
import com.github.shoothzj.javatool.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * @author hezhangjian
 */
@Slf4j
public class CaffeineConcurrentTest {

    private final AsyncLoadingCache<String, List<String>> childrenCache = Caffeine.newBuilder()
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

    @Test
    public void testVisit() throws Exception {
        LogUtil.configureLog();
        final CompletableFuture<List<String>> xxx = childrenCache.get("xxx");
        final List<String> arg = xxx.get();
        new Thread(() -> {
            final CompletableFuture<List<String>> yyy = childrenCache.get("xxx");
            try {
                log.info("{}", (arg == yyy.get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
        CommonUtil.sleep(TimeUnit.SECONDS, 10);
    }

    @Test
    public void testWhenComplete() throws Exception {
        LogUtil.configureLog();
        final CompletableFuture<List<String>> xxx = childrenCache.get("xxx");
        final List<String> arg = xxx.get();
        xxx.whenComplete(new BiConsumer<List<String>, Throwable>() {
            @Override
            public void accept(List<String> strings, Throwable throwable) {
                log.info("{}", arg == strings);
            }
        });
        CommonUtil.sleep(TimeUnit.SECONDS, 10);
    }

}
