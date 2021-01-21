package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18 {
	public static void main(String[] args) {
		//Multiply of a and b
		StdOut.println(mystery(2, 25));
		StdOut.println(mystery(3, 11));

		//Power of a and b, a power b.
		StdOut.println(mysteryWithAsteriks(4, 3));
		StdOut.println(mysteryWithAsteriks(3, 3));
	}

	public static int mystery(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

	public static int mysteryWithAsteriks(int a, int b) {
		if (b == 0) return 1;
		if (b % 2 == 0) return mysteryWithAsteriks(a * a, b / 2);
		return mysteryWithAsteriks(a * a, b / 2) * a;
	}
}
