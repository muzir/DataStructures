package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		if ((0.0 < x && x < 1.0) && (0.0 < y && y < 1.0)) {
			StdOut.println(true);
		} else {
			StdOut.println(false);
		}
	}
}
