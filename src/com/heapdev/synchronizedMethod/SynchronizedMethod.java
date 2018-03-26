package com.heapdev.synchronizedMethod;

public class SynchronizedMethod {

	private static int counter = 0;

	private static synchronized void incrementCounter() {
		for (int i = 0; i < 100; i++) {
			++counter;
		}

	}

	public static void process() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				incrementCounter();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				incrementCounter();
			}
		});

		t1.start();
		t2.start();

		// If you didn't make join here, it will print 0
		try {
			t1.join(); // Waiting t1 to be completed
			t2.join(); //// Waiting t2 to be completed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		process();
		System.out.println(counter);

	}

}
