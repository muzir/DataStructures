package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		if (a == b && b == c) {
			StdOut.println("equal");
		} else {
			StdOut.println("not equal");
		}
	}
}
