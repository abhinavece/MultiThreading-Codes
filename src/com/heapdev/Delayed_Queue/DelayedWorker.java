package com.heapdev.Delayed_Queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedWorker implements Delayed {

	private long duration;
	private String message;

	public DelayedWorker(long duration, String message) {
		this.duration = System.currentTimeMillis() + duration;
		this.message = message;
	}

	@Override
	public int compareTo(Delayed otherDelayed) {
		
		if (this.duration < ((DelayedWorker) otherDelayed).getDuration()) {
			return -1;
		}
		if (this.duration > ((DelayedWorker) otherDelayed).getDuration()) {
			return +1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}

}
