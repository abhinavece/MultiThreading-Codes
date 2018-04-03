package com.heapdev.Concurrent_Maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentMapApps {

	public static void main(String[] args) {

		ConcurrentMap<Character, Integer> hashMap = new ConcurrentHashMap<>();

		// ExecutorService executorService = Executors.newFixedThreadPool(2);
		//
		// executorService.submit(new WorkerA(hashMap));
		// executorService.submit(new WorkerB(hashMap));
		//
		// executorService.shutdown();

		new Thread(new WorkerA(hashMap)).start();
		new Thread(new WorkerB(hashMap)).start();

	}

}
