package org.algorithms.fundamentals.basicprogrammingmodel;

public class Exercise5 {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		if ((0.0 < x && x < 1.0) && (0.0 < y && y < 1.0)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
