package com.sun.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 启动一个线程
		ThreadPool threadPool = new ThreadPool();
		// new Thread(threadPool.new MyRunnable()).start();
		// threadPool.new MyThread().start();

		FutureTask<String> task = new FutureTask<String>(threadPool.new MyCallable());
		new Thread(task).start();
		System.out.println("The result of task is " + task.get());

		// 使用线程池
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(threadPool.new MyRunnable());
		executorService.execute(threadPool.new MyThread());
		executorService.submit(task);
		System.out.println("The result of task is " + task.get());
		executorService.shutdown();

	}

	class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println("This is MyRunnable...");
		}

	}

	class MyThread extends Thread {

		public void run() {
			System.out.println("This is MyThread...");
		}
	}

	class MyCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println("This is MyCallable...");
			return "SUCCESS";
		}
	}
}
