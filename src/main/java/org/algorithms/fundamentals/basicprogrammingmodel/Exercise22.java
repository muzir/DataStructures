package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise22 {
	private static int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

	public static void main(String[] args) {
		StdOut.println(indexOf(1, array));
		StdOut.println(indexOf(2, array));
		StdOut.println(indexOf(3, array));
		StdOut.println(indexOf(4, array));
		StdOut.println(indexOf(5, array));
		StdOut.println(indexOf(6, array));
		StdOut.println(indexOf(7, array));
		StdOut.println(indexOf(8, array));
		StdOut.println(indexOf(9, array));
		StdOut.println(indexOf(10, array));
	}

	private static int indexOf(int key, int[] array) {
		return indexOf(key, 0, array.length - 1, array, 0);
	}

	private static int indexOf(int key, int lo, int ho, int[] array, int depth) {
		StdOut.printf("lo: %d, ho: %d, depth: %d \n", lo, ho, depth);
		if (lo > ho) {
			return -1;
		}
		int mid = lo + (ho - lo) / 2;
		if (array[mid] == key) {
			return mid;
		} else if (array[mid] < key) {
			return indexOf(key, mid + 1, ho, array, depth + 1);
		} else {
			return indexOf(key, lo, mid - 1, array, depth + 1);
		}
	}
}
