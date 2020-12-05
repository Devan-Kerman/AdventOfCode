package net.devtech.AOC2020.problems.day3;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class TobboganSlopeThree implements Problem.CharArray {
	@Override
	public String solve(Clock clock, char[][] input) {
		clock.start();
		int counter = this.count(input, 3, 1);
		clock.stop();
		return Integer.toString(counter);
	}

	protected int count(char[][] input, int xSlope, int ySlope) {
		int x = 0, counter = 0;
		for (int y = 0; y < input.length; y+=ySlope) {
			if(this.get(input, x, y) == '#') {
				counter++;
			}
			x+=xSlope;
		}
		return counter;
	}


	private char get(char[][] in, int x, int y) {
		return in[y][x % in[y].length];
	}
}
