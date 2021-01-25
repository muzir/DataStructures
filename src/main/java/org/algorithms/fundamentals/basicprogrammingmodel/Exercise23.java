package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

public class Exercise23 {
	public static void main(String[] args) {
		In in = new In(System.getProperty("user.dir") + "/src/main/resources/" + args[0]);
		int[] whiteList = in.readAllInts();
		Arrays.sort(whiteList);
		String whiteListArgument = args[1];
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			int indexOfKey = indexOf(whiteList, key, 0, whiteList.length);
			if ((indexOfKey == -1 && whiteListArgument.equals("+")) ||
					(indexOfKey > -1 && whiteListArgument.equals("-"))) {
				println(key);
			}
		}
	}

	private static int indexOf(int[] whiteList, int key, int lo, int ho) {
		int midIndex = lo + ((ho - lo) / 2);
		if (lo > ho) return -1;
		if (whiteList[midIndex] > key) {
			return indexOf(whiteList, key, lo, midIndex - 1);
		} else if (key > whiteList[midIndex]) {
			return indexOf(whiteList, key, midIndex + 1, ho);
		}
		return midIndex;
	}
}
