package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class Exercise32 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double lo = Double.parseDouble(args[1]);
		double hi = Double.parseDouble(args[2]);
		drawHistogram(n, lo, hi);
	}

	private static void drawHistogram(int n, double lo, double hi) {
		double[] arr = StdIn.readAllDoubles();
		int[] frequencyArray = new int[n];
		double intervalValue = (hi - lo) / n;
		for (int i = 0; i < arr.length; i++) {
			double po = arr[i];
			if (po <= hi && po >= lo) {
				int frequencyIndex = (int) ((po - lo) / intervalValue);
				frequencyArray[frequencyIndex] = frequencyArray[frequencyIndex] + 1;
			}
		}
		StdOut.println(Arrays.toString(frequencyArray));
		for (int k = 0; k < frequencyArray.length; k++) {
			StdDraw.filledRectangle(k * 0.1, frequencyArray[k] * 0.1, 0.1, frequencyArray[k] * 0.1);
		}
	}
}
