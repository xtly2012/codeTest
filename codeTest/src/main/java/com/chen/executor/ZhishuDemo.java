package com.chen.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ZhishuDemo {
	public static List<Integer> zhishu(int start, int end) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = start; i < end; i++) {
			boolean isZhishu = true;
			if (i == 2) {
				list.add(2);
			}
			if (i == 3) {
				list.add(3);
			}
			for (int j = 2; j < Math.sqrt(i) + 1; j++) {
				if (i % j == 0) {
					isZhishu = false;
					break;
				}
			}
			if (isZhishu) {
				list.add(i);
			}
		}
		return list;
	}

	public static class MyRun implements Runnable {
		int start;
		int end;
		List<Integer> list;

		public MyRun(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public void run() {
			list = zhishu(start, end);
		}
	}

	public static class MyCallable implements Callable<List<Integer>> {
		private int end;
		private int begin;
		private List<Integer> list;

		public MyCallable(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		public List<Integer> call() throws Exception {
			this.list = zhishu(begin, end);
			return list;
		}
	}

	public static void main(String[] args) throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		ExecutorService threadPool = Executors.newCachedThreadPool();
		MyCallable call1 = new MyCallable(1, 5000000);
		MyCallable call2 = new MyCallable(5000000, 10000000);
		Future<List<Integer>> future1 = threadPool.submit(call1);
		Future<List<Integer>> future2 = threadPool.submit(call2);
		result.addAll(future1.get());
		result.addAll(future2.get());
		System.out.println("----------------------------------");
		for (Integer i : result) {
			System.out.println(i);
		}
	}
}