package net.devtech.AOC2020.problems.day6;

import java.util.Arrays;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class TotalAnswers implements Problem {
	@Override
	public String solve(Clock clock, String input) {
		clock.start();
		int sum = Arrays.stream(input.split("\n\n"))
		                .mapToInt(group -> (int) group.replace("\n", "")
		                                              .chars()
		                                              .distinct()
		                                              .count()
		                ).sum();
		clock.stop();
		return Integer.toString(sum);
	}
}
