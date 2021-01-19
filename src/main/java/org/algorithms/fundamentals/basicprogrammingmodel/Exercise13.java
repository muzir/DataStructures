package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise13 {
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5}, {2, 4, 6}};
		StdOut.println(Arrays.deepToString(transpose(matrix)));
	}

	private static int[][] transpose(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] transposeMatrix = new int[column][row];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				transposeMatrix[j][i] = matrix[i][j];
			}
		}
		return transposeMatrix;
	}
}
