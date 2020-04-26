package org.coursera.princeton.algorithms.week2.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.coursera.princeton.algorithms.week2.sort.UtilTest.generateRandomArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShellSortTest {
	Sortable shellSort = new ShellSort();

	@Test
	void verifyIntegerArraySortedSuccessfullyInAscendingOrder() {
		Integer[] array = {983, 324, 132, 12};
		shellSort.sort(array);
		System.out.println(Arrays.toString(array));
		assertEquals(12, array[0]);
		assertEquals(983, array[array.length - 1]);
	}

	@Test
	void verifyStringArraySortedAlphabetically() {
		String[] array = {"Jessy", "James", "Julia", "Frank", "Musa", "Cafer", "Stacey", "Jennifer", "John", "Alan", "Louis"};
		shellSort.sort(array);
		System.out.println(Arrays.toString(array));
		assertEquals("Alan", array[0]);
		assertEquals("Stacey", array[array.length - 1]);
	}

	@Test
	public void verifyZeroIsFirst_ifArrayVonstainsPossitiveRandomIntegers() {
		int n = 1000000;
		Integer[] randomArray = generateRandomArray(n);
		randomArray[n - 1] = 0;
		shellSort.sort(randomArray);
		System.out.println(Arrays.toString(randomArray));
		assertEquals(0, randomArray[0]);
	}
}
