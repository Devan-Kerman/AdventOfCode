package net.devtech.AOC2020.util;

import java.util.HashMap;
import java.util.Map;

import net.devtech.AOC2020.problems.day1.FindDoubleSum;
import net.devtech.AOC2020.problems.day1.FindTripleSum;
import net.devtech.AOC2020.problems.day2.PasswordCrack;
import net.devtech.AOC2020.problems.day2.PasswordCrack2;
import net.devtech.AOC2020.problems.day3.TobboganSlopeMulti;
import net.devtech.AOC2020.problems.day3.TobboganSlopeThree;
import net.devtech.AOC2020.problems.day4.CountExtraValidPassports;
import net.devtech.AOC2020.problems.day4.CountValidPassports;
import net.devtech.AOC2020.problems.day5.FindSeat;
import net.devtech.AOC2020.problems.day5.ValidateSeats;
import net.devtech.AOC2020.problems.day6.TotalAgreement;
import net.devtech.AOC2020.problems.day6.TotalAnswers;

public interface Problems {
	Map<IntPair, Problem> REGISTRY = new HashMap<>();
	Problem FIND_DOUBLE_SUM = register(1, 1, new FindDoubleSum());
	Problem FIND_TRIPLE_SUM = register(1, 2, new FindTripleSum());
	Problem PASSWORD_CRACK = register(2, 1, new PasswordCrack());
	Problem PASSWORD_CRACK2 = register(2, 2, new PasswordCrack2());
	Problem TOBBOGAN_SLOPE = register(3, 1, new TobboganSlopeThree());
	Problem TOBBOGAN_MULTI_SLOPE = register(3, 2, new TobboganSlopeMulti());
	Problem COUNT_VALID_PASSPORTS = register(4, 1, new CountValidPassports());
	Problem COUNT_EXRA_VALID_PASSPORTS = register(4, 2, new CountExtraValidPassports());
	Problem VALIDATE_SEATS = register(5, 1, new ValidateSeats());
	Problem FIND_SEAT = register(5, 2, new FindSeat());
	Problem TOTAL_ANSWERS = register(6, 1, new TotalAnswers());
	Problem TOTAL_AGREEMENT = register(6,2, new TotalAgreement());

	static Problem register(int day, int part, Problem problem) {
		REGISTRY.put(new IntPair(day, part), problem);
		return problem;
	}

	static Problem get(int day, int part) {
		return REGISTRY.get(new IntPair(day, part));
	}

}
