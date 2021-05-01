package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public class LinkedListQueue<V> implements Queue<V> {

	private Node first;
	private Node last;
	private int counter;

	@Override
	public void enqueue(V item) {
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		counter++;
	}

	@Override
	public V dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		V item = first.item;
		counter--;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterator<V> iterator() {
		return new QueueIterator();
	}

	@Override
	public String toString() {
		Iterator<V> iterator = iterator();
		String s = "";
		while (iterator.hasNext()) {
			s = s + iterator.next() + " ";
		}
		return s;
	}

	private class Node {
		V item;
		Node next;
	}

	private class QueueIterator implements Iterator {
		private Node tempFirst = first;

		public boolean hasNext() {
			return tempFirst != null;
		}

		public V next() {
			V item = tempFirst.item;
			tempFirst = tempFirst.next;
			return item;
		}
	}
}
