package org.coursera.princeton.algorithms.week2;

import java.util.stream.IntStream;

public class FixedCapacityStackOfStrings implements Stack<String> {

	private int capacity;
	private String[] container;
	private int n;

	public FixedCapacityStackOfStrings(int capacity) {
		this.n = 0;
		this.capacity = capacity;
		container = new String[capacity];
	}

	@Override
	public void push(String item) {
		container[n] = item;
		n++;
		if (n == capacity) {
			resize(2 * capacity);
		}
	}

	@Override
	public String pop() {
		if (n == 0) {
			throw new EmptyStackException("Stack is empty");
		}
		if (n <= capacity / 4) {
			resize(capacity / 2);
		}
		String value = container[n - 1];
		container[n - 1] = null;
		n--;
		return value;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public int size() {
		return n;
	}

	private void resize(int newCapacity) {
		System.out.println("Resize stack capacity from " + this.capacity + " to " + newCapacity);
		String[] copyContainer = new String[newCapacity];
		IntStream.range(0, n).forEach(i -> copyContainer[i] = container[i]);
		this.container = copyContainer;
		this.capacity = newCapacity;
	}
}
