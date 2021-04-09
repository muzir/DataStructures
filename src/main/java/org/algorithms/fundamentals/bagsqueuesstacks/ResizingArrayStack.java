package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {

	private int n;
	private int capacity;
	private T[] array;

	public ResizingArrayStack(int capacity) {
		this.n = 0;
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public void push(T item) {
		if (n > capacity / 2) {
			T[] temp = Arrays.copyOf(array, array.length);
			this.capacity = 2 * capacity;
			array = (T[]) new Object[capacity];

		}
	}

	@Override
	public T pop() {
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}
}
