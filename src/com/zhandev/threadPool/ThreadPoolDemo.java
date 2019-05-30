package com.zhandev.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	static final int POOL_SIZE = 3;
	
	public static void main(String[] args) {
		
		// 1. Create Runnable tasks.
		Runnable task1 = new Task("Task 1");
		Runnable task2 = new Task("Task 2");
		Runnable task3 = new Task("Task 3");
		Runnable task4 = new Task("Task 4");
		Runnable task5 = new Task("Task 5");
		
		// 2. Create Executor thread pool.
		ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
		
		// 3. Pass tasks to thread pool.
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.execute(task5);
		
		// 4. Shut down thread pool.
		pool.shutdown();
	}
}

class Task implements Runnable {

	private String taskName;
	
	public Task(String name) {
		taskName = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(taskName + " is running - " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(taskName + " completes.");
	}
	
}