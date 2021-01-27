package org.algorithms.fundamentals.basicprogrammingmodel;

import static edu.princeton.cs.algs4.StdOut.printf;

public class Exercise26 {
	public static void main(String[] args) {

		sortAndPrintInAscendingOrder(10, 12, 11);
		sortAndPrintInAscendingOrder(12, 11, 10);
		sortAndPrintInAscendingOrder(11, 12, 10);
	}

	private static void sortAndPrintInAscendingOrder(int a, int b, int c) {
		if (a > b) {
			int t = a;
			a = b;
			b = t;
		}
		if (a > c) {
			int t = a;
			a = c;
			c = t;
		}
		if (b > c) {
			int t = b;
			b = c;
			c = t;
		}

		printf("a:%d,b:%d,c:%d \n", a, b, c);
	}

}
