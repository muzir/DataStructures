package org.algorithms.fundamentals.basicprogrammingmodel;

public class Exercise27 {
	static int counter = 0;

	public static void main(String[] args) {
		System.out.println(binomial(3, 2, 0.25));
	}

	public static double binomial(int n, int k, double p) {
		if ((n == 0) && (k == 0)) return 1.0;
		if ((n < 0) || (k < 0)) return 0.0;
		System.out.println("counter:" + counter++ + " n:" + n + " k:" + k);
		return (1 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);
	}
}
