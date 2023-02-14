package com.sap.gcs.mcco.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceErrorHandlingExample {

    private static Random r = new Random();

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        AtomicInteger threadIndex = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(20,
                r -> new Thread(r, "example-thread-" + threadIndex.getAndIncrement()));

        try {
            List<CompletableFuture<Integer>> completableFutures = new ArrayList<>();
            for(int i=0; i<5; i++) {

                    completableFutures.add(
                            CompletableFuture.supplyAsync(() -> method1(), executorService)
                                    .thenApply(a -> method2(a))
                                    .exceptionally(e -> 0) // handle exception, otherwise we will not be able to retrieve any successful futures
                            );
            }

//            CompletableFuture<List<Integer>> result = CompletableFuture
//                    .allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]))
//                    .thenApply(v -> completableFutures.stream().map(CompletableFuture::join)
//                            .collect(Collectors.toList()));
//
//            for(Integer n: result.get()) {
//                System.out.println(n);
//            }

            CompletableFuture<Void> combinedFutures = CompletableFuture
                    .allOf(completableFutures.toArray(new CompletableFuture[0]));
            combinedFutures.get(); // block until all tasks have completed

            // collect results for all futures
            for(CompletableFuture result: completableFutures) {
                Integer n = (Integer) result.get();
                System.out.println(n);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            executorService.shutdownNow();
        }

    }

    public static Integer method1() {
        return r.nextInt();
    }

    public static Integer method2(Integer i) {
        if(i<0)
            throw new RuntimeException("Error");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + r.nextInt();
    }
}
