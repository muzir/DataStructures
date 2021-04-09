package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

import static edu.princeton.cs.algs4.StdOut.println;

public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {

	private int n = 0;
	private T[] array = (T[]) new Object[1];

	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack<>();
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		stack.push("to");
		stack.push("be");


		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();


		Iterator iterator = stack.iterator();
		while (iterator.hasNext()) {
			println(iterator.next());
		}
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
		if (array.length == n) resize(2 * array.length);
		array[n++] = item;
	}

	private void resize(int capacity) {
		T[] temp = (T[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		T item = array[--n];
		array[n] = null;
		if (n > 0 && n == array.length / 4) resize(array.length / 2);
		return item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<T> {

		private int i = n - 1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public T next() {
			return array[i--];
		}
	}
}
