package org.algorithms.fundamentals.basicprogrammingmodel;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

interface Matrix {
	double dot(double[] x, double[] y);

	double[][] mult(double[][] a, double[][] b);

	double[][] transpose(double[][] a);
}

public class Exercise33 implements Matrix {

	public static void main(String[] args) {
		Matrix matrix = new Exercise33();
		double[] x = {1, 3, -5};
		double[] y = {4, -2, -1};
		println(matrix.dot(x, y));
		double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		double[][] at = matrix.transpose(a);
		printMatrix(at);
		double[][] b = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
		printMatrix(matrix.mult(a, b));
	}

	private static void printMatrix(double[][] at) {
		for (double[] row : at) {
			println(Arrays.toString(row));
		}
	}

	@Override
	public double dot(double[] x, double[] y) {
		if (x.length != y.length) {
			throw new IllegalArgumentException("arguments array size must be equal fpr dot operation");
		}
		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum = sum + (x[i] * y[i]);
		}
		return sum;
	}

	@Override
	public double[][] mult(double[][] a, double[][] b) {
		if (a.length != b[0].length) {
			throw new IllegalArgumentException("first matrix row number is not equal to second matrix column number");
		}
		double[][] c = new double[a.length][b[0].length];
		double[][] bt = transpose(b);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				c[i][j] = dot(a[i], bt[j]);
			}
		}
		return c;
	}

	@Override
	public double[][] transpose(double[][] a) {
		double[][] at = new double[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				at[j][i] = a[i][j];
			}
		}
		return at;
	}
}
