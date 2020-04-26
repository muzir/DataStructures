package org.coursera.princeton.algorithms.week2.sort;

public class ShellSort implements Sortable {
	Integer[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};

	@Override
	public void sort(Comparable[] array) {
		int n = array.length;
		for (Integer gap : gaps) {
			for (int i = gap; i < n; i++) {
				Comparable current = array[i];
				for (int j = i - gap; j >= 0; j = j - gap) {
					if (current.compareTo(array[j]) < 1) {
						Comparable swap = array[j];
						array[j] = current;
						array[j + gap] = swap;
					}
				}
			}
			System.out.println("Gap:" + gap);
		}
	}
}
