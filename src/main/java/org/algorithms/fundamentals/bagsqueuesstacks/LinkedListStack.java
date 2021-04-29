package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LinkedListStack<V> implements Stack<V> {

	private int counter;
	private Node top;

	@Override
	public boolean isEmpty() {
		return counter == 0;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public void push(V item) {
		Node newItem = new Node();
		newItem.item = item;
		newItem.next = top;
		top = newItem;
		counter++;
	}

	@Override
	public V pop() {
		if (top == null) {
			new IllegalStateException("Stack is empty");
		}
		counter--;
		V item = top.item;
		top = top.next;
		return item;
	}

	@Override
	public Iterator<V> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<V> {

		private Node tempTop = top;

		@Override
		public boolean hasNext() {
			return tempTop != null;
		}

		@Override
		public V next() {
			V item = tempTop.item;
			tempTop = tempTop.next;
			return item;
		}
	}

	private class Node {
		V item;
		Node next;
	}
}
