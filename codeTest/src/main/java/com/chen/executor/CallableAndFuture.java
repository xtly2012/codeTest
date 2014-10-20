package com.chen.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(4000);
				return "hello";
			}
		});
		System.out.println("等待结果。。。。");
		try {
			System.out.println("the return result : "
					+ future.get(1, TimeUnit.SECONDS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------");

		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);// 创建10个指定大小的线程池
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				threadPool2);
		for (int i = 1; i <= 10; i++) {
			final int n = i;
			completionService.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return n;
				}
			});
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(completionService.take().get());// 获得最早完成任务的Future。
		}
	}
}