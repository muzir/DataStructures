package org.coursera.princeton.algorithms.week2.sort;

import org.junit.jupiter.api.Test;

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
}
