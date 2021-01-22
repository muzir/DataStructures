package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {
	public static void main(String[] args) {
		StdOut.println(ln(3));
		StdOut.println(ln(2));
	}

	private static double ln(long n) {
		if (n == 1) {
			return 0.0;
		}
		return Math.log(n) + ln(n - 1);
	}
}
