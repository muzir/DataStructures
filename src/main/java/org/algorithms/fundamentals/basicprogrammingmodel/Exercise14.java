package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise14 {
	public static void main(String[] args) {
		int param = 15;
		StdOut.println(lg(param));
	}

	private static int lg(int param) {
		int baseTwoCounter = 0;
		while (param > 0) {
			param = param / 2;
			baseTwoCounter++;
		}
		return baseTwoCounter - 1;
	}
}
