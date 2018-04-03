package com.heapdev.Priority_Queue;

import java.util.concurrent.BlockingQueue;

public class SecondWorkerClass implements Runnable {

	private BlockingQueue<Student> blockingQueue;

	public SecondWorkerClass(BlockingQueue<Student> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		try {
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
