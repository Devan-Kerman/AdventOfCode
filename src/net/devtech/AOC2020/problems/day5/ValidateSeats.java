package net.devtech.AOC2020.problems.day5;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class ValidateSeats implements Problem.StringArray {
	private static final int ROW_MASK = 0b100;
	private static final int COLUMN_MASK = 0b10;

	@Override
	public String solve(Clock clock, String[] input) {
		clock.start();
		int max = 0;
		for (String s : input) {
			int row = getRow(s);
			int column = getColumn(s);
			int seatId = row << 3 | column;
			if (seatId > max) {
				max = seatId;
			}
		}
		clock.stop();
		return Integer.toString(max);
	}

	static int getRow(String s) {
		int row = 0;
		for (int i = 0; i < 7; i++) {
			int bit = 6 - i;
			row |= ((s.charAt(i) & ROW_MASK) >> 2 ^ 0b1) << bit;
		}
		return row;
	}

	static int getColumn(String s) {
		int column = 0;
		for (int i = 0; i < 3; i++) {
			int bit = 2 - i;
			column |= ((s.charAt(i + 7) & COLUMN_MASK) >> 1) << bit;
		}
		return column;
	}
}
