package com.heapdev.Exchanger;

import java.util.concurrent.Exchanger;

public class SecondThread implements Runnable {

	private Exchanger<Integer> exchange;

	public SecondThread(Exchanger<Integer> exchange) {
		this.exchange = exchange;
	}

	@Override
	public void run() {

		int counter = 100;

		while (true) {
			counter = counter - 10;
			System.out.println("Second Thread is decrementing the counter by 10: " + counter);

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
