package net.devtech.AOC2020.problems.day2;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class PasswordCrack implements Problem.StringArray {
	@Override
	public String solve(Clock clock, String[] input) {
		int counter = 0;
		clock.start();
		for (String s : input) {
			if(this.isValid(s)) counter++;
		}
		clock.stop();
		return Integer.toString(counter);
	}

	private boolean isValid(String string) {
		int stack = 0;

		int min = -1, max = -1, count = 0;
		char target = 0;
		for (int i = 0; i < string.length(); i++) {
			char chr = string.charAt(i);
			if(chr == '-' && min == -1) {
				min = Integer.parseInt(string.substring(stack, i));
				stack = i;
			} else if(chr == ' ' && max == -1) {
				max = Integer.parseInt(string.substring(stack+1, i));
				stack = i;
			} else if(chr == ':' && target == 0) {
				target = string.charAt(i-1);
				stack = i;
			} else if(target == chr) {
				count++;
				if(count > max) {
					return false;
				}
			}
		}

		return count >= min && count <= max;
	}
}
