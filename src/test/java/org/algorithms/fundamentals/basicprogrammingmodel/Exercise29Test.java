package org.algorithms.fundamentals.basicprogrammingmodel;

import org.junit.jupiter.api.Test;

import static org.algorithms.fundamentals.basicprogrammingmodel.Exercise29.count;
import static org.algorithms.fundamentals.basicprogrammingmodel.Exercise29.rank;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise29Test {
	@Test
	void simpleDuplicateArrayTest() {
		int[] arr = {10, 10};
		assertEquals(0, rank(10, arr));
		assertEquals(2, count(10, arr));
	}

	@Test
	void midDuplicateArrayTest() {
		int[] arr = {4, 5, 10, 10};
		assertEquals(2, rank(10, arr));
		assertEquals(2, count(10, arr));
	}

	@Test
	void longDuplicateArrayTest() {
		int[] arr = {4, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		assertEquals(2, rank(10, arr));
		assertEquals(11, count(10, arr));
	}
}
