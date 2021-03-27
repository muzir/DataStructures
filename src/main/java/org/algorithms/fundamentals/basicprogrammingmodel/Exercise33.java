package org.algorithms.fundamentals.basicprogrammingmodel;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

interface Matrix {
	double dot(double[] x, double[] y);

	double[][] mult(double[][] a, double[][] b);

	double[][] transpose(double[][] a);

	double[] mult(double[][] a, double[] x);

	/*TODO in the book this method dscribed as vector-vector product page 60
	 *  but parameters are vector and matrix, not sure parameters are correct
	 * */
	double[] mult(double[] y, double[][] a);
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
		double[][] a1 = {{1, -1, 2}, {0, -3, 1}};
		double[] x1 = {2, 1, 0};
		println(Arrays.toString(matrix.mult(a1, x1)));
		println(Arrays.toString(matrix.mult(x1, a1)));
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

	@Override
	public double[] mult(double[][] a, double[] x) {
		if (a[0].length != x.length) {
			throw new IllegalArgumentException("matrix column number is not equal to vector column number");
		}
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			double acc = 0;
			for (int j = 0; j < a[0].length; j++) {
				acc = acc + (a[i][j] * x[j]);
			}
			result[i] = acc;
		}
		return result;
	}

	@Override
	public double[] mult(double[] y, double[][] a) {
		return mult(a, y);
	}
}
