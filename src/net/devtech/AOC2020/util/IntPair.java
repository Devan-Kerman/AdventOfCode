package net.devtech.AOC2020.util;

public final class IntPair {
	private final int day, part, hash;

	public IntPair(int day, int part) {
		this.day = day;
		this.part = part;

		int result = this.day;
		result = 31 * result + this.part;
		this.hash = result;
	}

	@Override
	public int hashCode() {
		return this.hash;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof IntPair)) {
			return false;
		}
		IntPair pair = (IntPair) object;
		if (this.day != pair.day) {
			return false;
		}
		return this.part == pair.part;
	}
}