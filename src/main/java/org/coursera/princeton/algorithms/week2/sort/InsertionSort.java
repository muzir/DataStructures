package org.coursera.princeton.algorithms.week2.sort;


import java.util.Arrays;

public class InsertionSort implements Sortable {
	@Override
	public void sort(Comparable[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			Comparable current = array[i];
			int currentIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				Comparable prev = array[j];
				if (current.compareTo(prev) < 1) {
					swap(currentIndex, j, array);
					currentIndex = j;
				} else {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	private void swap(int currentIndex, int prevIndex, Comparable[] array) {
		Comparable swapElement = array[currentIndex];
		array[currentIndex] = array[prevIndex];
		array[prevIndex] = swapElement;
	}
}
