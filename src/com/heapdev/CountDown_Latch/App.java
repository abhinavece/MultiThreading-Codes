package com.heapdev.CountDown_Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link java.util.concurrent.CountDownLatch} Java class to synchronize your
 * threads’ activities. <br>
 * <br>
 * Source:
 * <em>http://stackoverflow.com/questions/17827022/what-is-countdown-latch-in-java-multithreading</em><br>
 *
 * Any thread, usually main thread of application, which calls
 * {@link java.util.concurrent.CountDownLatch#await()} will wait until count
 * reaches zero or its interrupted by another thread. All other thread are
 * required to do count down by calling
 * {@link java.util.concurrent.CountDownLatch#countDown()} once they are
 * completed or ready. <br>
 * 
 * 
 * As soon as count reaches zero, Thread awaiting starts running. One of the
 * disadvantage of {@link java.util.concurrent.CountDownLatch} is that it's not
 * reusable once the count reaches to zero you can not use
 * {@link java.util.concurrent.CountDownLatch} any more. <br>
 * <br>
 * 
 * 
 * Use {@link java.util.concurrent.CountDownLatch} when one thread, like main
 * thread, require to wait for one or more threads to complete, before it can
 * start processing. <br>
 * <br>
 * 
 * Classical example of using {@link java.util.concurrent.CountDownLatch} in
 * Java is any server side core Java application which uses services
 * architecture, where multiple services are provided by multiple threads and
 * application can not start processing until all services have started
 * successfully. <br>
 * <br>
 *  *
 * 
 */

public class App {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(10);

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Worker(i + 1, latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All the prerequisites are done !!");
		executorService.shutdown();
	}

}

class Worker implements Runnable {

	private int id;
	private CountDownLatch countDownLatch;

	public Worker(int id, CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
		this.id = id;
	}

	@Override
	public void run() {

		doSomeWork();
		countDownLatch.countDown();
	}

	private void doSomeWork() {
		System.out.println("Therad with id: " + id + " is executing...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
