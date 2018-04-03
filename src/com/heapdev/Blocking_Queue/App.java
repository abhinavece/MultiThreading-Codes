package com.heapdev.Blocking_Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public FirstWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		int count = 0;

		while (true) {
			try {
				blockingQueue.add(count);
				System.out.println("ADDED to the queue- INTEGER::" + count);
				count++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<Integer> blockingQueue;

	public SecondWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {

		while (true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Removed to the queue- INTEGER::" + number);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

public class App {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

		FirstWorker firstWorker = new FirstWorker(queue);
		SecondWorker secondWorker = new SecondWorker(queue);

		new Thread(firstWorker).start();
		new Thread(secondWorker).start();

	}

}
