package com.heapdev.Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {

	ISNTANCE;
	private Semaphore semaphore = new Semaphore(3, true);

	public void downloadData() {

		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private void download() {

		System.out.println("Downloading data from the web... ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SemaphoresApp {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					Downloader.ISNTANCE.downloadData();
				}
			});
		}
		executor.shutdown();
	}
}