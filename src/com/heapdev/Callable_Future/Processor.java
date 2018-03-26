package com.heapdev.Callable_Future;

import java.util.concurrent.Callable;

public class Processor implements Callable<String> {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(500);
		return "id: " + id;
	}

}
