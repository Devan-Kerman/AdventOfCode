package net.devtech.AOC2020.problems.day5;

import static net.devtech.AOC2020.problems.day5.ValidateSeats.getColumn;
import static net.devtech.AOC2020.problems.day5.ValidateSeats.getRow;

import java.util.Arrays;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class FindSeat implements Problem.StringArray {
	@Override
	public String solve(Clock clock, String[] input) {
		clock.start();
		int[] data = new int[32];
		for (String s : input) {
			int row = getRow(s);
			int column = getColumn(s);
			int seatId = row << 3 | column;
			data[seatId >> 5] |= 1 << (seatId & 31);
		}


		boolean lastFlag = false, lastLastFlag = false;
		int lastId = 0;
		for (int i = 0; i < 1024; i++) {
			int flag = data[i >> 5] & 1 << (i & 31);
			if(lastLastFlag && !lastFlag && flag != 0) {
				clock.stop();
				return Integer.toString(lastId);
			}

			lastLastFlag = lastFlag;

			lastFlag = flag != 0;
			lastId = i;
		}

		clock.stop();
		return "<err>";
	}
}
