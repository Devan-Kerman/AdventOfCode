package net.devtech.AOC2020.problems.day3;

import net.devtech.AOC2020.util.Clock;

public class TobboganSlopeMulti extends TobboganSlopeThree {
	@Override
	public String solve(Clock clock, char[][] input) {
		clock.start();
		long mul = this.count(input, 1, 1);
		mul *= this.count(input, 3, 1);
		mul *= this.count(input, 5, 1);
		mul *= this.count(input, 7, 1);
		mul *= this.count(input, 1, 2);
		clock.stop();
		return Long.toString(mul);
	}
}
