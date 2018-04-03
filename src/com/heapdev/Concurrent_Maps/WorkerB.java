package com.heapdev.Concurrent_Maps;

import java.util.concurrent.ConcurrentMap;

public class WorkerB implements Runnable {

	private ConcurrentMap<Character, Integer> map;

	public WorkerB(ConcurrentMap<Character, Integer> map) {
		this.map = map;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(5000);
			System.out.println(map.get('B'));
			System.out.println(map.get('P'));
			Thread.sleep(1000);
			System.out.println(map.get('L'));
			System.out.println(map.get('A'));
			System.out.println(map.get('X'));
			Thread.sleep(1000);
			System.out.println(map.get('Z'));
			System.out.println(map.get('Y'));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
