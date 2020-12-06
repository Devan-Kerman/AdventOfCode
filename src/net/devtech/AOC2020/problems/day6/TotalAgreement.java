package net.devtech.AOC2020.problems.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class TotalAgreement implements Problem {
	private static final List<Character> START = new ArrayList<>();

	static {
		for (char i = 'a'; i <= 'z'; i++) {
			START.add(i);
		}
	}

	@Override
	public String solve(Clock clock, String input) {
		String[] arr = input.split("\n\n");
		int sum = 0;
		for (String s : arr) {
			Set<Character> common = new HashSet<>(START);
			Arrays.stream(s.split("\n"))
			      .map(person -> person.chars()
			                           .mapToObj(i -> (char) i)
			                           .collect(Collectors.toSet()))
			      .forEach(common::retainAll);
			sum += common.size();
		}
		return Integer.toString(sum);
	}
}
