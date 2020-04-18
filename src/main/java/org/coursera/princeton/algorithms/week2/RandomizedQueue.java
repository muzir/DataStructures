package org.coursera.princeton.algorithms.week2;

import java.util.Iterator;

public class RandomizedQueue<Item> implements RandomizedDeque<Item> {

	public RandomizedQueue() {
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public void enqueue(Object o) {

	}

	@Override
	public Item dequeue() {
		return null;
	}

	@Override
	public Item sample() {
		return null;
	}

	@Override
	public Iterator iterator() {
		return new RandomIterator();
	}


	private class RandomIterator implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Item next() {
			return null;
		}
	}
}
