package org.coursera.princeton.algorithms.week2.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellSortTest {
	Sortable shellSort = new ShellSort();

	@Test
	void verifyIntegerArraySortedSuccessfullyInAscendingOrder() {
		Integer[] array = {983, 324, 132, 12};
		shellSort.sort(array);
		assertEquals(12, array[0]);
	}
}
