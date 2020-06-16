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
		if (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
			swim(k);
		}
	}

	private boolean less(int firstNodeIndex, int secondNodeIndex) {
		return container[firstNodeIndex].compareTo(container[secondNodeIndex]) < 0;
	}

	private void exch(int k, int i) {
		Key temp = container[k];
		container[k] = container[i];
		container[i] = temp;
	}

	@Override
	public Key delMax() {
		Key maxKey = container[1];
		exch(1, index);
		sink(1);
		container[--index] = null;
		return maxKey;
	}

	private void sink(int k) {
		int maxChildIndex = giveMaxChildIndex(k);
		if (index > 2 * k && less(k, maxChildIndex)) {
			exch(k, maxChildIndex);
			k = maxChildIndex;
			sink(k);
		}
	}

	private int giveMaxChildIndex(int k) {
		if (less(2 * k, 2 * k + 1)) {
			return 2 * k + 1;
		}
		return 2 * k;
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
