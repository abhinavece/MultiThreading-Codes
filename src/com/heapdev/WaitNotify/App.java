package com.heapdev.WaitNotify;

public class App {

	private void produce() throws InterruptedException {

		synchronized (this) {
			System.out.println("Gettting inside produce method");
			wait();
			System.out.println("Again inside produce() method.... !!");
		}

	}

	private void consume() throws InterruptedException {

		Thread.sleep(3000);

		synchronized (this) {
			System.out.println("Gettting inside consume method");
			notify();
			System.out.println("Below code still executing after calling notify...");
			Thread.sleep(3000);
		}

	}

	public static void main(String[] args) {

		App app = new App();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					app.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					app.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

	}

}
