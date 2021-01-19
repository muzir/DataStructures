package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {
	public static void main(String[] args) {
		int param = Integer.parseInt(args[0]);
		StdOut.println(convertToBinary(param));
	}

	private static String convertToBinary(int param) {
		String s = "";
		while (param > 0) {
			int remainder = param % 2;
			s = remainder + s;
			param = param / 2;
		}
		return s;
	}
}
