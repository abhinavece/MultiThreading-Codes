package com.heapdev.Priority_Queue;

import java.util.concurrent.BlockingQueue;

public class FirstWorkerClass implements Runnable {

	private BlockingQueue<Student> blockingQueue;

	public FirstWorkerClass(BlockingQueue<Student> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			blockingQueue.put(new Student("Ankit", 26, 17));
			blockingQueue.put(new Student("Zabeen", 21, 21));
			blockingQueue.put(new Student("Suresh", 32, 56));
			blockingQueue.put(new Student("Namrata", 19, 22));
			blockingQueue.put(new Student("Gireesh", 12, 3));
			blockingQueue.put(new Student("Shweta", 23, 4));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
