package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise28 {
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);
		Integer[] noDuplicateWhitelist = removeDuplicates(whitelist);
		while (!StdIn.isEmpty()) {
			// Read key, print if not in whitelist
			int key = StdIn.readInt();
			if (indexOf(noDuplicateWhitelist, key) == -1) {
				StdOut.println(key);
			}
		}
	}

	private static Integer[] removeDuplicates(int[] whitelist) {
		Set<Integer> set = new TreeSet<>();
		Arrays.stream(whitelist).forEach(i -> { set.add(i); });
		Integer[] noDuplicateWhitelist = set.stream().toArray(Integer[]::new);
		return noDuplicateWhitelist;
	}

	private static int indexOf(Integer[] whitelist, int key) {
		int lo = 0;
		int hi = whitelist.length - 1;
		while (hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			if (whitelist[mid] > key) {
				hi = mid - 1;
			} else if (whitelist[mid] < key) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
