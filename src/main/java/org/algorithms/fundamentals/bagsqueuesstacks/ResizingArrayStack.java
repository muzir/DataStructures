package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T> {

	private T[] container;
	private int n;

	public ResizingArrayStack(int capacity) {
		this.container = (T[]) new Object[capacity];
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
		if (n == container.length) {
			resize(2 * n);
		}
		container[n++] = item;
	}

	@Override
	public T pop() {
		T item = container[--n];
		container[n] = null;
		if (n > 0 && n == container.length - 1 / 4) {
			resize(n / 2);
		}
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private void resize(int newCapacity) {
		T[] temp = (T[]) new Object[newCapacity];
		for (int i = 0; i < n; i++) {
			temp[i] = container[i];
		}
		container = temp;
	}

	private class ReverseArrayIterator implements Iterator<T> {
		private int tempN = n;

		@Override
		public boolean hasNext() {
			return tempN != 0;
		}

		@Override
		public T next() {
			return container[--tempN];
		}
	}
}
