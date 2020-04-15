package org.coursera.princeton.algorithms.week2;

public class FixedCapacityStackOfStrings implements Stack<String> {

	private final int capacity;
	private final String[] container;
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
	}

	@Override
	public String pop() {
		if (n == 0) {
			throw new EmptyStackException("Stack is empty");
		}
		String value = container[n - 1];
		container[n - 1] = null;
		n--;
		return value;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return n;
	}
}
