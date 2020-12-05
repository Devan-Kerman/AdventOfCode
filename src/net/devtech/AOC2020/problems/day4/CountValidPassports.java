package net.devtech.AOC2020.problems.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class CountValidPassports implements Problem {
	// cid
	private final Set<String> required = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));

	@Override
	public String solve(Clock clock, String input) {
		clock.start();
		String[] pass = input.split("\n\n");
		int valid = 0;
		for (String s : pass) {
			String[] keyValues = s.split("([ \n])");
			int counter = 0;
			for (String value : keyValues) {
				String[] kv = value.split(":");
				if(this.isValid(kv[0], kv[1])) {
					counter++;
				}
			}
			if(counter == this.required.size()) {
				valid++;
			}
		}
		clock.stop();
		return Integer.toString(valid);
	}

	protected boolean isValid(String key, String value) {
		return this.required.contains(key);
	}
}
