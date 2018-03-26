package com.heapdev.Callable_Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newFixedThreadPool(2);
		List<Future<String>> futureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Future<String> future = executors.submit(new Processor(i + 1));
			futureList.add(future);
		}

		executors.shutdown();

		for (Future<String> fString : futureList) {
			try {
				System.out.println(fString.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
