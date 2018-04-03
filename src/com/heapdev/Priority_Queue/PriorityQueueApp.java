package com.heapdev.Priority_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueApp {

	public static void main(String[] args) {

		BlockingQueue<Student> queue = new PriorityBlockingQueue<>();

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(new FirstWorkerClass(queue));
		executorService.submit(new SecondWorkerClass(queue));

		executorService.shutdown();

		// new Thread(new FirstWorkerClass(queue)).start();
		// new Thread(new SecondWorkerClass(queue)).start();

	}

}
