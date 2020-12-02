package net.devtech.AOC2020.util;

public class Clock {
	private long start, elapsed;
	public long start() {
		return this.start = System.nanoTime();
	}

	public long stop() {
		return this.elapsed += System.nanoTime() - this.start;
	}

	public long getElapsed() {
		return this.elapsed;
	}

	public void reset() {
		this.elapsed = 0;
		this.start = 0;
	}
}
