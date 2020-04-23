package org.coursera.princeton.algorithms.week2.sort;

public class SelectionSort implements Sortable {

	@Override
	public void sort(Comparable[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				minIndex = findMinIndex(minIndex, j, array);
			}
			swap(i, minIndex, array);
		}
	}

	private void swap(int i, int minIndex, Comparable[] array) {
		Comparable swap = array[i];
		array[i] = array[minIndex];
		array[minIndex] = swap;
	}

	private int findMinIndex(int minIndex, int parameterIndex, Comparable[] array) {
		if (array[minIndex].compareTo(array[parameterIndex]) > 0) {
			return parameterIndex;
		}
		return minIndex;
	}
}
