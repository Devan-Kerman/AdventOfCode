package net.devtech.AOC2020.problems.day5;

import static net.devtech.AOC2020.problems.day5.ValidateSeats.getColumn;
import static net.devtech.AOC2020.problems.day5.ValidateSeats.getRow;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class FindSeat implements Problem.StringArray {
	@Override
	public String solve(Clock clock, String[] input) {
		clock.start();
		int min = Integer.MAX_VALUE, max = 0;
		long sum = 0;
		for (String s : input) {
			int row = getRow(s);
			int column = getColumn(s);
			int seatId = row << 3 | column;

			if(seatId > max) max = seatId;
			else if(seatId < min) min = seatId;
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
