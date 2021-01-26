package org.algorithms.fundamentals.basicprogrammingmodel;

import static edu.princeton.cs.algs4.StdOut.println;

public class Exercise24 {
	public static void main(String[] args) {
//		println(gcd(105, 24));
		int p = Integer.parseInt(args[0]);
		int q = Integer.parseInt(args[1]);
		println(gcd(p, q));
	}

	private static int gcd(int p, int q) {
		println("p:" + p + ", q:" + q);
		if (q == 0) {
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
}
