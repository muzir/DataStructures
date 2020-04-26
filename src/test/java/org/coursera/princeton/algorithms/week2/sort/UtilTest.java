package org.coursera.princeton.algorithms.week2.sort;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class UtilTest {
	static Integer[] generateRandomArray(int arraySize) {
		Integer[] randomArray = new Integer[arraySize];
		SecureRandom secureRandom = new SecureRandom();
		IntStream.range(0, arraySize).forEach(i -> randomArray[i] = secureRandom.nextInt(arraySize));
		return randomArray;
	}
}
