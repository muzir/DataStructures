package org.coursera.princeton.algorithms.week2.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.coursera.princeton.algorithms.week2.sort.UtilTest.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

	Sortable insertionSort = new InsertionSort();

	@Test
	void verifyIntegerArraySortAscending() {
		Integer[] array = {90, 87, 12, 12, 32, 10};
		insertionSort.sort(array);
		assertEquals(10, array[0]);
	}

	@Test
	void verifyStringArraySortAlphabetically() {
		String[] array = {"Simon", "Jane", "Jack"};
		insertionSort.sort(array);
		assertEquals("Jack", array[0]);
	}

	@Test
	public void verifyZeroIsFirst_ifArrayVonstainsPossitiveRandomIntegers() {
		int n = 10000;
		Integer[] randomArray = generateRandomArray(n);
		randomArray[n - 1] = 0;
		insertionSort.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		assertEquals(0, randomArray[0]);
	}
}
