package org.algorithms.fundamentals.basicprogrammingmodel;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise34 {
	public static void main(String[] args) {
		/*Print the maximum and minimum numbers; filtering is enough with fixed variables*/
		double min = 1.0;
		double max = 0.0;
		while (!StdIn.isEmpty()) {
			min = Double.min(min, StdIn.readDouble());
			max = Double.max(max, StdIn.readDouble());
		}
		StdOut.print("min:" + min);
		StdOut.print("max:" + max);

	}
}
