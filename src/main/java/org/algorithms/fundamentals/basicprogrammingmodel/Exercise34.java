package org.algorithms.fundamentals.basicprogrammingmodel;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise34 {
	public static void main(String[] args) {

		List<Double> numbers = new ArrayList<>();

		/*Print the maximum and minimum numbers; filtering is enough with fixed variables*/
		double min = 1.0;
		double max = 0.0;
		while (!StdIn.isEmpty()) {
			final double parameter = StdIn.readDouble();
			numbers.add(parameter);
			min = Double.min(min, parameter);
			max = Double.max(max, parameter);
		}

		StdOut.println("min:" + min + " max:" + max);

		/*Print the median of the numbers*/
		printMedianOfTheNumbers(numbers);
	}

	private static void printMedianOfTheNumbers(List<Double> numbers) {
		int size = numbers.size();
		Double[] sortedNumbers = numbers.stream().sorted(Comparator.naturalOrder()).toArray(Double[]::new);
		String message = String.format("Median:%s", sortedNumbers[size / 2]);
		StdOut.println(message);
	}
}
