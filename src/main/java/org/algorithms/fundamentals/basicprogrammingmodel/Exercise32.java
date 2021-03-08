package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


public class Exercise32 {
	public static void main(String[] args) {
		//drawSample();
		int n = Integer.parseInt(args[0]);
		double lo = Double.parseDouble(args[1]);
		double hi = Double.parseDouble(args[2]);
		drawHistogram(n, lo, hi);
	}

	private static void drawHistogram(int n, double lo, double hi) {
		while(!StdIn.isEmpty()){
			double[] allDoubles = StdIn.readAllDoubles();

		}
	}

	private static void drawHistogram() {

	}


	private static void drawSample() {
		int n = 50;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = StdRandom.uniform();
		}

		for (int i = 0; i < n; i++) {
			double x = 1.0 * i / n;
			double y = a[i] / 2.0;
			double rw = 0.5 / n;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}
