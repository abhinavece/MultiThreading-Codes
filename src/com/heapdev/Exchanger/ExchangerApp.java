package com.heapdev.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Therads can exchange Object/Variable between threads using exchange() method
 * 
 * They Swaps the object among themselves eg:-
 * 
 * 1st loop Execution:
 * 
 * Thread1 counter value was 101 and Thread2's counter value was 90
 * 
 * Now they swapped/exchanged their values among themselves. Thread1 value
 * became 90 and Thread2 value became 101.
 * 
 * 2nd loop Execution:
 * 
 * Thread1 increments the value by 1, i.e. 91 and Therad2 decremented by 10 so
 * new value is 101-10=91, so both became 91
 * 
 * Again they swapped the value against themselves and this continues...
 * 
 * @author Abhinav
 *
 */

public class ExchangerApp {

	public static void main(String[] args) {

		Exchanger<Integer> exchanger = new Exchanger<>();

		// ExecutorService executorService = Executors.newFixedThreadPool(1);
		// executorService.submit(new FirstThread(exchanger));
		// executorService.submit(new SecondThread(exchanger));
		//
		// executorService.shutdown();

		new Thread(new FirstThread(exchanger)).start();
		new Thread(new SecondThread(exchanger)).start();

	}

}
