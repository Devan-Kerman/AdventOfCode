package net.devtech.AOC2020.problems.day5;

import static net.devtech.AOC2020.problems.day5.ValidateSeats.getId;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class FindSeat implements Problem.StringArray {
	@Override
	public String solve(Clock clock, String[] input) {
		clock.start();
		int min = Integer.MAX_VALUE, max = 0;
		long sum = 0;
		for (String s : input) {
			int seatId = getId(s);
			max = Math.max(max, seatId);
			min = Math.min(min, seatId);
			sum += seatId;
		}

		long total = sumSeries(min, max) - sum;
		clock.stop();
		return Long.toString(total);
	}

	private static long sumSeries(int min, int max) {
		int n = (max - min + 1);
		return (long)n * (min + max) / 2;
	}
}
