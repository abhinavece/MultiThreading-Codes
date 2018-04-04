package com.heapdev.Dining_Philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilosopherApp {

	public static void main(String[] args) {

		ExecutorService executorService = null;
		Philosopher[] philosophers = null;

		try {

			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
			ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICKS];

			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
				chopSticks[i] = new ChopStick(i);
			}

			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {

				philosophers[i] = new Philosopher(i, chopSticks[i],
						chopSticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICKS]);

				executorService.submit(philosophers[i]);
			}
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

			for (Philosopher p : philosophers) {
				p.setFull(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();

			if (!executorService.isTerminated()) {
				try {
					Thread.sleep(1000);
					System.out.println();
					System.out.println();
					System.out.println("******************Calculation Time*******************");
					System.out.println();
					System.out.println();

					for (Philosopher p : philosophers) {
						System.out.println(p + " eats " + p.getEatingCounter() + " times.");
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
