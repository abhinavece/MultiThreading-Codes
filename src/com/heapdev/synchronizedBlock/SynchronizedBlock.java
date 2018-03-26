package com.heapdev.synchronizedBlock;

public class SynchronizedBlock {

	private static int counter1 = 0;
	private static int counter2 = 0;

	// If addFirst is called , then addSecond will wait this to be completed
	// because it is class level intrinsic lock
	/*
	 * private static synchronized void addFirst() { ++counter1; }
	 * 
	 * private static synchronized void addSecond() { ++counter2; }
	 */

	// This will also not work, it's also a class level intrinsic lock
	// private static void addFirst() {
	// synchronized (SynchronizedBlock.class) {
	// ++counter1;
	// }
	// }

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static void addFirst() {
		synchronized (lock1) {
			++counter1;
		}
	}

	private static void addSecond() {
		synchronized (lock2) {
			++counter2;
		}
	}

	private static void compute() {
		for (int i = 0; i < 100; i++) {
			addFirst();
			addSecond();

		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				compute();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("counter1: " + counter1);
		System.out.println("counter2: " + counter2);
	}

}
