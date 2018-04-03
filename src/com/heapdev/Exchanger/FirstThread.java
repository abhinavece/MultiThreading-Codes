package com.heapdev.Exchanger;

import java.util.concurrent.Exchanger;

public class FirstThread implements Runnable {

	private Exchanger<Integer> exchange;

	public FirstThread(Exchanger<Integer> exchange) {
		this.exchange = exchange;
	}

	@Override
	public void run() {

		int counter = 100;

		while (true) {
			counter++;
			System.out.println("First Thread is incrementing the counter by 1: " + counter);

			try {
				counter = exchange.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
