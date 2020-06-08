package org.coursera.princeton.algorithms.week4;

public class UnorderedPriorityQueue<Key extends Comparable<Key>> implements Queue<Key> {

	private final Key[] container;
	private int lastIndexPointer;

	public UnorderedPriorityQueue(int capacity) {
		this.container = (Key[]) new Comparable[capacity];
		this.lastIndexPointer = 0;
	}

	@Override
	public void insert(Key key) {
		/**TODO add container full check, compare capacity and lastIndexPointer*/
		container[lastIndexPointer++] = key;
	}

	@Override
	public Key delMax() {
		/**TODO add container empty check*/
		int max = 0;
		for (int i = 0; i < lastIndexPointer; i++) {
			if (container[i].compareTo(container[max]) > 0) {
				max = i;
			}
		}
		swap(max, lastIndexPointer - 1);
		return container[--lastIndexPointer];
	}

	private void swap(int max, int indexPointer) {
		Key temp = container[max];
		container[max] = container[indexPointer];
		container[indexPointer] = temp;
	}

	@Override
	public boolean isEmpty() {
		return lastIndexPointer == 0;
	}
}
