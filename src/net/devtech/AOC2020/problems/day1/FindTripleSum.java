package net.devtech.AOC2020.problems.day1;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class FindTripleSum implements Problem.IntArray {
	@Override
	public String solve(Clock clock, int[] arr) {
		clock.start();
		for (int x = 0; x < arr.length; x++) {
			int a = arr[x];
			for (int y = x+1; y < arr.length; y++) {
				int b = arr[y];
				for (int z = y+1; z < arr.length; z++) {
					int c = arr[z];
					if(a + b + c == 2020) {
						clock.stop();
						return Integer.toString(a * b * c);
					}
				}
			}
		}
		throw new IllegalStateException("Unable to find sum!");
	}
}
