package com.heapdev.Delayed_Queue;

/**
 * 
 * An object is only taken from delayed queue when it's delay has expired.
 * 
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayedQueueApp {

	public static void main(String[] args) {

		BlockingQueue<DelayedWorker> queue = new DelayQueue<>();

		try {
			queue.put(new DelayedWorker(1000, "First Entry..."));
			queue.put(new DelayedWorker(10000, "Second Entry..."));
			queue.put(new DelayedWorker(5000, "Third Entry..."));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (!queue.isEmpty()) {
			try {
				// An object is only taken from delayed queue when it's delay has expired.
				System.out.println("Taking back" + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}