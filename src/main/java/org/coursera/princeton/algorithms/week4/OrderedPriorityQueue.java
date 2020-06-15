package org.coursera.princeton.algorithms.week4;

import java.util.Arrays;

public class OrderedPriorityQueue<Key extends Comparable<Key>> implements Queue<Key> {

	private final Key[] container;
	private int index;

	public OrderedPriorityQueue(int n) {
		this.container = (Key[]) new Comparable[n + 1];
		this.index = 0;
	}

	@Override
	public void insert(Key key) {
		container[++index] = key;
		swim(index);
	}

	private void swim(int k) {
		if (k > 1 &&
				(container[k / 2].compareTo(container[k]) > 0)) {
			exch(k, k / 2);
			k = k / 2;
			swim(k);
		}
	}

	private void exch(int k, int i) {
		Key temp = container[k];
		container[k] = container[i];
		container[i] = temp;
	}

	@Override
	public Key delMax() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String toString() {
		return "OrderedPriorityQueue{" +
				"container=" + Arrays.toString(container) +
				", index=" + index +
				'}';
	}
}
