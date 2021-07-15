package org.algorithms.fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {

	public static void main(String[] args) {
		int n = 5;
		int intersectIntervalCounter = 0;
		double[] uniformDistributedValues = findUniformDistributedValues(n, 0.0, 1.0);
		List<Interval2D> interval2DList = getInterval2DsRandomly(uniformDistributedValues, n);
		interval2DList.forEach(interval2D -> {
			interval2D.draw();
		});
		for (int i = 0; i < interval2DList.size() - 1; i++) {
			Interval2D outerInterval2D = interval2DList.get(i);
			for (int j = i + 1; j < interval2DList.size(); j++) {
				Interval2D innerInterval2D = interval2DList.get(j);
				if (outerInterval2D.intersects(innerInterval2D)) {
					intersectIntervalCounter++;
				}
			}
		}
		System.out.println(intersectIntervalCounter);
	}

	static double[] findUniformDistributedValues(int n, double min, double max) {
		if (min < 0.0) {
			throw new IllegalArgumentException("min can't be less than 0.0");
		}
		if (1.0 < max) {
			throw new IllegalArgumentException("max can't be more than 1.0");
		}
		if (max <= min) {
			throw new IllegalArgumentException("max should be bigger than min");
		}
		double k = (max - min) / n;
		double[] arr = new double[n];
		int index = 0;
		for (double i = min; i < max; i = i + k) {
			arr[index] = i;
			index++;
		}
		return arr;
	}

	static List<Interval2D> getInterval2DsRandomly(double[] array, int n) {
		int i = 0;
		List<Interval2D> interval2DList = new ArrayList<>();
		while (i < n) {
			Interval1D width = getInterval1DRandomly(n, array);
			Interval1D height = getInterval1DRandomly(n, array);
			Interval2D interval2D = new Interval2D(width, height);
			interval2DList.add(interval2D);
			i++;
		}
		return interval2DList;
	}

	private static Interval1D getInterval1DRandomly(int n, double[] array) {
		int leftIndex;
		int rightIndex;
		while (1 == 1) {
			leftIndex = StdRandom.uniform(n);
			rightIndex = StdRandom.uniform(n);
			if (array[leftIndex] <= array[rightIndex]) {
				break;
			}
		}
		return new Interval1D(array[leftIndex], array[rightIndex]);
	}
}
