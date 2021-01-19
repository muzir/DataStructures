package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuestionAnswer {
	public static void main(String[] args) {
		StdOut.println(Math.abs(-2147483648));
		Double infinity = Double.POSITIVE_INFINITY;
		Double negativeInfinity = Double.NEGATIVE_INFINITY;
		StdOut.println(infinity);
		StdOut.println(negativeInfinity);

		int x = 3;
		if (x < 3.1) {
			StdOut.println("3.1 double literal x converted to double.");
		}
		//StdOut.println(1 / 0);
		StdOut.println(1.0 / 0.0);
		if (false | true) {
			StdOut.println("Single | works");
		}
		if (false & true) {
			StdOut.println("Single & works");
		}
		int[] a = {1, 2, 3};
		StdOut.println(a);
		StdOut.println(Arrays.toString(a));
	}
}
