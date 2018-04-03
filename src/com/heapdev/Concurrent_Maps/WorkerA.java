package com.heapdev.Concurrent_Maps;

import java.util.concurrent.ConcurrentMap;

public class WorkerA implements Runnable {

	private ConcurrentMap<Character, Integer> map;

	public WorkerA(ConcurrentMap<Character, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {

		try {
			map.put('A', 22);
			Thread.sleep(1000);
			map.put('X', 32);
			map.put('Z', 34);
			Thread.sleep(1000);
			map.put('Y', 356);
			map.put('L', 422);
			Thread.sleep(1000);
			map.put('P', 6789);
			map.put('B', 4312);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
