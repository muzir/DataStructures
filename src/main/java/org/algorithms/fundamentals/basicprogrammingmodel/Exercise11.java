package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {
	public static void main(String[] args) {
		boolean[][] matrix = {{true, false, false}, {true, true, true}, {false, true, true}};
		print(matrix);
	}

	private static void print(boolean[][] matrix) {
		String s = "  ";
		for (int i = 0; i < matrix[0].length; i++) {
			s = s + i + " ";
		}
		s = s + " \n";
		for (int i = 0; i < matrix.length; i++) {
			s = s + i + " ";
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					s = s + "* ";
				} else {
					s = s + "  ";
				}
			}
			s = s + " \n";
		}
		StdOut.println(s);
	}
}
