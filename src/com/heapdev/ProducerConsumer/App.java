package com.heapdev.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {

	public static List<Integer> pizzas = new ArrayList<>();

	private final int LIMIT = 10;
	private final int BOTTOM = 0;
	private int value = 0;

	public void produce() throws InterruptedException {

		synchronized (this) {
			System.out.println("Inside produce method ::::: =====>>>>>>>");

			while (true) {

				if (pizzas.size() == LIMIT) {
					System.out.println("Waiting to get consumed ...");
					wait();
				} else {
					System.out.println("Producing Pizza :: " + value);
					pizzas.add(value);
					++value;
					 notify();
				}
				Thread.sleep(500);
			}
		}

	}

	public void consume() throws InterruptedException {

		synchronized (this) {
			System.out.println("Inside Consume method ::::::: ======>>>>>>");

			while (true) {

				if (pizzas.size() != BOTTOM) {
					pizzas.remove(--value);
					System.out.println("Consuming Pizza " + pizzas.size());

					notify();
					// ===> Why it didn't go to other thread from here ??? Why it's still removing
					// Pizza ???
					// Because After notify if there is any further code, That further code will be
					// executed,
					// and Since this is in while loop that loop gets executed.
					// When condition failed, It went to else part and wait() call took to producer method.
					
					//TODO: What if you remove notify() call from here
				} else {
					System.out.println("Waiting to get it produced");
					wait();
				}
				Thread.sleep(500);
			}

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
