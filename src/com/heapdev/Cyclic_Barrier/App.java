package com.heapdev.Cyclic_Barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("This thread has started execution.... !!!!!!!!");
			}
		});

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++) {
			executorService.execute(new Worker(i + 1, cyclicBarrier));
		}
		executorService.shutdown();

	}

}

class Worker implements Runnable {

	private int id;
	private CyclicBarrier cyclicBarrier;
	private Random random;

	public Worker(int id, CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
		this.id = id;
		this.random = new Random();
	}

	@Override
	public void run() {

		doSomeJobHere();
	}

	private void doSomeJobHere() {
		System.out.println("Thread with ID " + id + " started task....");

		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Thread with ID " + id + " ended task....");

		try {
			// Waits for the execution completes for each thread.
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

	public String toString() {
		return "" + this.id;
	}

}