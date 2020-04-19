package org.coursera.princeton.algorithms.week2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements RandomDeque<Item> {

	private final Iterator<Item> iterator;
	private Item[] container;
	private int tailIndex;
	private int size;
	private int capacity;

	public RandomizedQueue() {
		this.capacity = 10;
		this.container = (Item[]) new Object[capacity];
		this.iterator = new RandomIterator();
	}

	@Override
	public boolean isEmpty() {
		return container == null || size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(Item item) {
		nullCheck(item);
		if (!isEmpty()) {
			tailIndex++;
		}
		if (tailIndex == capacity - 1) {
			resize(2 * capacity);
		}
		container[tailIndex] = item;
		size++;
	}

	private void resize(int newCapacity) {
		Item[] newContainer = (Item[]) new Object[newCapacity];
		for (int i = 0; i < capacity; i++) {
			newContainer[i] = container[i];
		}
		this.container = newContainer;
		this.capacity = newCapacity;
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
		return container[StdRandom.uniform(size)];
	}

	private void checkQueueIsEmpty() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public Iterator iterator() {
		StdRandom.shuffle(container);
		return iterator;
	}

	private class RandomIterator implements Iterator<Item> {

		private int index;

		public RandomIterator() {
		}

		@Override
		public boolean hasNext() {
			return index != capacity;
		}

		@Override
		public Item next() {
			checkQueueIsEmpty();
			Item item = container[index];
			index++;
			return item;
		}
	}
}
