package org.coursera.princeton.algorithms.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements RandomDeque<Item> {

	private Item[] container;
	private int firstIndex;
	private int tailIndex;
	private int size;

	public RandomizedQueue() {
		this.container = (Item[]) new Object[10];
	}

	@Override
	public boolean isEmpty() {
		return container == null || container.length == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(Item item) {
		nullCheck(item);
		container[tailIndex] = item;
		size++;
	}

	private void nullCheck(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Parameter can not be null");
		}
	}

	@Override
	public Item dequeue() {
		checkQueueIsEmpty();
		return null;
	}

	@Override
	public Item sample() {
		checkQueueIsEmpty();
		return null;
	}

	private void checkQueueIsEmpty() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
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
			checkQueueIsEmpty();
			return null;
		}
	}
}
