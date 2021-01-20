package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise16 {
	public static void main(String[] args) {
		// 311361142246
		StdOut.println(exR1(6));
	}

	private static String exR1(int n) {
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
}
