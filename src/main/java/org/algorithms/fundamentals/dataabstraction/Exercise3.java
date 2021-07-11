package org.algorithms.fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;

public class Exercise3 {


	public static void main(String[] args) {

		Interval1D x = new Interval1D(.2, .5);
		Interval1D y = new Interval1D(.5, .6);
		Interval2D interval2D = new Interval2D(x, y);
		interval2D.draw();

	}

	double[] findUniformDistributedValues(int n, double min, double max) {
		double k = (max - min) / n;
		double[] arr = new double[n];
		int index = 0;
		for (double i = min; i < max; i = i + k) {
			arr[index] = i;
			index++;
		}
		return arr;
	}
}
