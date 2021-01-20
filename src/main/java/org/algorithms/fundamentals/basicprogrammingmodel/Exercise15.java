package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise15 {
	public static void main(String[] args) {
		int[] a = {1, 2, 4, 2, 2, 2, 4, 4, 0};
		int m = 5;
		int[] histogramArray = histogram(a, m);
		StdOut.printf("Array sum %s and initial array length %s", Arrays.stream(histogramArray).sum(), a.length);
	}

	private static int[] histogram(int[] a, int m) {
		int[] mArray = new int[m];
		for (int i = 0; i < m; i++) {
			mArray[i] = frequency(i, a, m);
		}
		return mArray;
	}

	/*
	 * If the values in a[] between 0 and m-1
	 * */
	private static void checkValueBetweenInRange(int arrayIndexValue, int m) {
		if (!(0 < arrayIndexValue && arrayIndexValue <= (m - 1))) {
			throw new IllegalArgumentException("Array values should be between 0 and " + (m - 1) + ", " + arrayIndexValue + " is not in that range");
		}
	}

	private static int frequency(int arrayIndex, int[] a, int m) {
		int counter = 0;
		for (int j = 0; j < a.length; j++) {
			checkValueBetweenInRange(a[arrayIndex], m);
			if (arrayIndex == a[j]) {
				counter++;
			}
		}
		return counter;
	}
}
