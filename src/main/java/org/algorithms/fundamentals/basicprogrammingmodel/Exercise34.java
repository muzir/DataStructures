package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.princeton.cs.algs4.StdOut.println;
import static java.util.Comparator.naturalOrder;

public class Exercise34 {
	public static void main(String[] args) {

		List<Double> numbers = new ArrayList<>();

		/* Print the maximum and minimum numbers; filtering is enough with fixed variables */
		double min = 1.0;
		double max = 0.0;
		double sumOfTheSquaresOfTheNumbers = 0.0;
		double sumOfTheNumbers = 0.0;
		double averageOfTheNumbers = 0.0;
		int numberCounter = 0;
		while (!StdIn.isEmpty()) {
			numberCounter++;
			final double parameter = StdIn.readDouble();
			numbers.add(parameter);
			min = Double.min(min, parameter);
			max = Double.max(max, parameter);
			sumOfTheSquaresOfTheNumbers += parameter * parameter;
			sumOfTheNumbers += parameter;
			averageOfTheNumbers = sumOfTheNumbers / numberCounter;
		}

		println("min: " + min + " max: " + max);
		Double[] sortedNumbers = numbers.stream().sorted(naturalOrder()).toArray(Double[]::new);
		/* Print the median of the numbers */
		printMedianOfTheNumbers(sortedNumbers);
		int k = 4;
		/* Print the kth smallest value */
		printKthSmallestNumbers(sortedNumbers, k);

		/* Print the sum of the squares of the numbers */
		println("Sum of the squares of the numbers: " + sumOfTheSquaresOfTheNumbers);
		/* Print average of the numbers */
		println("Average of the numbers: " + averageOfTheNumbers);

		/* Print the percentage of the numbers greater than the average */
		printThePercentageOfTheNumbersGreaterThanTheAverage(sortedNumbers, averageOfTheNumbers);

		/* Print the numbers in increasing order*/
		printTheNumbersInIncreasingOrder(sortedNumbers);
		/* Print the numbers in random order*/
		printTheNumbersInRandomOrder(sortedNumbers);
	}

	private static void printTheNumbersInRandomOrder(final Double[] sortedNumbers) {
		Double[] newSortedArray = Arrays.copyOf(sortedNumbers, sortedNumbers.length);
		for (int i = 0; i < newSortedArray.length; i++) {
			int firstIndex = StdRandom.uniform(newSortedArray.length);
			int secondIndex = StdRandom.uniform(newSortedArray.length);
			Double temp = newSortedArray[firstIndex];
			newSortedArray[firstIndex] = newSortedArray[secondIndex];
			newSortedArray[secondIndex] = temp;
		}
		println("The numbers in random order: " + Arrays.toString(newSortedArray));
	}

	private static void printTheNumbersInIncreasingOrder(Double[] sortedNumbers) {
		println("The numbers in increasing order: " + Arrays.toString(sortedNumbers));
	}

	private static void printThePercentageOfTheNumbersGreaterThanTheAverage(Double[] sortedNumbers, double averageOfTheNumbers) {
		int indexOfTheFirstNumberGreaterThanTheAverage = -1;
		for (int i = 0; i < sortedNumbers.length; i++) {
			if (averageOfTheNumbers < sortedNumbers[i]) {
				indexOfTheFirstNumberGreaterThanTheAverage = i;
				break;
			}
		}
		final double countOfTheNumbersGreaterThanTheAverage = sortedNumbers.length - indexOfTheFirstNumberGreaterThanTheAverage;
		final double total = sortedNumbers.length;
		final double percentage = (countOfTheNumbersGreaterThanTheAverage / total) * 100.00;
		String result = String.format("The percentage of the numbers greater than the average : %.2f", percentage);
		println(result);
	}

	private static void printKthSmallestNumbers(Double[] numbers, int k) {
		if (k > numbers.length) {
			String exceptionMessage = String.format("k:%s is greater than numbers size: %s", k, numbers.length);
			throw new IllegalArgumentException(exceptionMessage);
		}
		String result = String.format("%sth smallest number is %s", k, numbers[k]);
		println(result);
	}

	private static void printMedianOfTheNumbers(Double[] numbers) {
		int size = numbers.length;
		String message = String.format("median: %s", numbers[size / 2]);
		println(message);
	}
}
