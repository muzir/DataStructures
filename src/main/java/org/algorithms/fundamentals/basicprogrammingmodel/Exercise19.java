package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {
	private static int N = 90;
	private static long[] cache = new long[N];

	public static void main(String[] args) {
		for (int n = 0; n < N; n++) {
			long fibonacciResult = fibonacci(n);
			StdOut.println(n + " " + fibonacciResult);
			cache[n] = fibonacciResult;
		}
	}

	public static long fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (cache[n] != 0) return cache[n];
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
