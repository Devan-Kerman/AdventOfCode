package net.devtech.AOC2020.problems.day5;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class ValidateSeats implements Problem.StringArray {


	@Override
	public String solve(Clock clock, String[] input) {
		clock.start();
		int max = 0;
		for (String s : input) {
			int seatId = getId(s);
			if (seatId > max) {
				max = seatId;
			}
		}
		clock.stop();
		return Integer.toString(max);
	}

	private static final int ROW_MASK = 0b100;
	static int getId(String s) {
		int seatId = 0;
		for (int i = 0; i < 10; i++) {
			int bit = 9 - i;
			seatId |= ((s.charAt(i) & ROW_MASK) >> 2 ^ 0b1) << bit;
		}
		return seatId;
	}
}
