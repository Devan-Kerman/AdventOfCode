package net.devtech.AOC2020.util;

public interface Problem {
	interface IntArray extends Problem {
		@Override
		default String solve(Clock clock, String input) {
			String[] arr = input.split("\n");
			int[] ints = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				ints[i] = Integer.parseInt(arr[i]);
			}

			return this.solve(clock, ints);
		}

		String solve(Clock clock, int[] input);
	}

	interface StringArray extends Problem {
		@Override
		default String solve(Clock clock, String input) {
			return this.solve(clock, input.split("\n"));
		}

		String solve(Clock clock, String[] input);
	}

	interface CharArray extends Problem {
		@Override
		default String solve(Clock clock, String input) {
			String[] str = input.split("\n");
			char[][] chars = new char[str.length][];
			for (int i = 0; i < str.length; i++) {
				chars[i] = str[i].toCharArray();
			}

			return this.solve(clock, chars);
		}

		/**
		 * @param input input[y][x]
		 */
		String solve(Clock clock, char[][] input);
	}

	String solve(Clock clock, String input);
}
