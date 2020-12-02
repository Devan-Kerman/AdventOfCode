package net.devtech.AOC2020.problems.day2;

import net.devtech.AOC2020.util.Clock;
import net.devtech.AOC2020.util.Problem;

public class PasswordCrack2 implements Problem.StringArray {
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

		int first = -1, second = -1;
		char target = 0;
		for (int i = 0; i < string.length(); i++) {
			char chr = string.charAt(i);
			if(chr == '-' && first == -1) {
				first = Integer.parseInt(string.substring(stack, i));
				stack = i;
			} else if(chr == ' ' && second == -1) {
				second = Integer.parseInt(string.substring(stack+1, i));
				stack = i;
			} else if(chr == ':') {
				target = string.charAt(i-1);
				stack = i;
				break;
			}
		}

		// start at space to artificially add back index = 0
		int passwordStart = stack+1;
		return string.charAt(first + passwordStart) == target ^ string.charAt(second + passwordStart) == target;
	}
}
