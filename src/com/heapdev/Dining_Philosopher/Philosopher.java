package com.heapdev.Dining_Philosopher;

import java.util.Random;

public class Philosopher implements Runnable {

	private int id;
	private ChopStick leftChopStick;
	private ChopStick rightChopStick;
	private Random random;
	private int eatingCounter;
	private volatile boolean isFull = false;

	public Philosopher() {
		// TODO Auto-generated constructor stub
	}

	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		this.random = new Random();
	}

	@Override
	public void run() {

		try {
			while (!isFull) {
				think();

				if (leftChopStick.pickup(this, State.LEFT)) {
					if (rightChopStick.pickup(this, State.RIGHT)) {

						eat();
						rightChopStick.putDown(this, State.RIGHT);
					}
					leftChopStick.putDown(this, State.LEFT);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating now, Luckily got both the chopsticks !! ");
		Thread.sleep(random.nextInt(1000));
	}

	private void think() throws InterruptedException {
		System.out.println(this + " is thinking... !!");
		this.eatingCounter++;
		Thread.sleep(random.nextInt(1000));
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public int getEatingCounter() {
		return eatingCounter;
	}

	@Override
	public String toString() {
		return "philosopher " + id;
	}

}
