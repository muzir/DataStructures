package org.algorithms.fundamentals.bagsqueuesstacks;


import java.util.Iterator;

public class LinkedListBag<V> implements Bag<V> {

	private Node first;
	private int counter;

	@Override
	public void add(V item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = first;
		first = newNode;
		counter++;
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
		return new BagIterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<V> iterator = new BagIterator();
		iterator.forEachRemaining(i -> sb.append(i).append(" "));
		return sb.toString();
	}

	private class Node {
		V item;
		Node next;
	}

	private class BagIterator implements Iterator<V> {
		private Node tempFirst = first;

		@Override
		public boolean hasNext() {
			return tempFirst != null;
		}

		@Override
		public V next() {
			V item = tempFirst.item;
			tempFirst = tempFirst.next;
			return item;
		}
	}
}
