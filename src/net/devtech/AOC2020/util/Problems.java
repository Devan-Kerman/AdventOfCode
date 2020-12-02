package net.devtech.AOC2020.util;

import java.util.HashMap;
import java.util.Map;

import net.devtech.AOC2020.problems.day1.FindDoubleSum;
import net.devtech.AOC2020.problems.day1.FindTripleSum;
import net.devtech.AOC2020.problems.day2.PasswordCrack;
import net.devtech.AOC2020.problems.day2.PasswordCrack2;

public interface Problems {
	Map<IntPair, Problem> REGISTRY = new HashMap<>();
	Problem FIND_DOUBLE_SUM = register(1, 1, new FindDoubleSum());
	Problem FIND_TRIPLE_SUM = register(1, 2, new FindTripleSum());
	Problem PASSWORD_CRACK = register(2, 1, new PasswordCrack());
	Problem PASSWORD_CRACK2 = register(2, 2, new PasswordCrack2());

	static Problem register(int day, int part, Problem problem) {
		REGISTRY.put(new IntPair(day, part), problem);
		return problem;
	}

	static Problem get(int day, int part) {
		return REGISTRY.get(new IntPair(day, part));
	}

}
