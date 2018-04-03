package com.heapdev.CountDown_Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Employee implements Runnable {

	private int id;
	private CountDownLatch latch;

	public Employee(int id, CountDownLatch latch) {

		this.id = id;
		this.latch = latch;

	}

	@Override
	public void run() {

		calculateNeuralNetworkAndAnalyseTheData();
		latch.countDown();
	}

	private void calculateNeuralNetworkAndAnalyseTheData() {
		System.out.println("Some analysis to be performed here... !!");

		for (int i = 0; i < 5; i++) {
			System.out.println("Executing Neural analysis at this point for method " + (i + 1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Test {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			executors.submit(new Employee(i + 1, latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("**********************DONE****************************");
		executors.shutdown();
	}

}
