package org.algorithms.fundamentals.basicprogrammingmodel;

import java.util.Arrays;

public class QuestionAnswer {
	public static void main(String[] args) {
		System.out.println(Math.abs(-2147483648));
		Double infinity = Double.POSITIVE_INFINITY;
		Double negativeInfinity = Double.NEGATIVE_INFINITY;
		System.out.println(infinity);
		System.out.println(negativeInfinity);

		int x = 3;
		if (x < 3.1) {
			System.out.println("3.1 double literal x converted to double.");
		}
//		System.out.println(1 / 0);
		System.out.println(1.0 / 0.0);
		if (false | true) {
			System.out.println("Single | works");
		}
		if (false & true) {
			System.out.println("Single & works");
		}
		int[] a = {1,2,3};
		System.out.println(a);
		System.out.println(Arrays.toString(a));
	}
}
