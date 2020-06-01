package org.coursera.princeton.algorithms.week4;

import java.util.Arrays;
import java.util.Comparator;

public class UnorderedPriorityQueue<Key extends Comparable<Key>> implements Queue<Key> {

	private final Key[] container;
	private int lastIndexPointer;

	public UnorderedPriorityQueue(int capacity) {
		this.container = (Key[]) new Object[capacity];
		this.lastIndexPointer = 0;
	}

	@Override
	public void insert(Key key) {
		container[lastIndexPointer++] = key;
	}

	@Override
	public Key delMax() {
		return Arrays.stream(container).max(Comparator.naturalOrder()).orElse(null);
	}

	@Override
	public boolean isEmpty() {
		return lastIndexPointer == 0;
	}
}
