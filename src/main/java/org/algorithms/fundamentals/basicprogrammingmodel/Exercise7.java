package org.algorithms.fundamentals.basicprogrammingmodel;


import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Exercise7 {
	public static void main(String[] args) {
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > 0.001) t = (9.0 / t + t) / 2.0;
		printf("%.5f\n", t);

		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		println(sum);

		int sum1 = 0;
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sum1++;
			}
		}
		println(sum1);
	}
}
