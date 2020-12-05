package net.devtech.AOC2020.problems.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.devtech.AOC2020.util.Clock;

public class CountExtraValidPassports extends CountValidPassports {
	private final Set<String> eyeColors = new HashSet<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

	@Override
	protected boolean isValid(String key, String value) {
		int i;
		switch (key) {
		case "byr":
			i = Integer.parseInt(value);
			return i >= 1920 && i <= 2002;
		case "iyr":
			i = Integer.parseInt(value);
			return i >= 2010 && i <= 2020;
		case "eyr":
			i = Integer.parseInt(value);
			return i >= 2020 && i <= 2030;
		case "hgt":
			boolean metric = true;
			int index = value.indexOf("cm");
			if (index == -1) {
				metric = false;
				index = value.indexOf("in");
			}
			if(index == -1) return false;
			i = Integer.parseInt(value.substring(0, index));
			if (metric) {
				return i >= 150 && i <= 193;
			} else {
				return i >= 59 && i <= 76;
			}
		case "hcl":
			if (value.charAt(0) == '#') {
				return Integer.parseInt(value.substring(1), 16) <= 0xffffff;
			}
			return false;
		case "ecl":
			return this.eyeColors.contains(value);
		case "pid":
			try {
				i = Integer.parseInt(value);
				return value.length() == 9;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
}
