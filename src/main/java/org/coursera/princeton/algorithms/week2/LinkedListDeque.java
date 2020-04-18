package org.coursera.princeton.algorithms.week2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<Item> implements Deque<Item> {

	private Node first;
	private Node last;
	private int size;

	public LinkedListDeque() {
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void addFirst(Item item) {
		validateNullCheck(item);
		Node newNode = new Node(item, first);
		first = newNode;
		size++;
	}

	@Override
	public void addLast(Item item) {
		validateNullCheck(item);
		Node newNode = new Node(item, last);
		last = newNode;
		size++;
	}

	private void validateNullCheck(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Parameter can not be null");
		}
	}

	@Override
	public Item removeFirst() {
		validateDequeIsNotEmpty();
		Item item = first.item;
		first = first.prev;
		size--;
		return item;
	}

	private void validateDequeIsNotEmpty() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public Item removeLast() {
		validateDequeIsNotEmpty();
		Item item = last.item;
		last = last.prev;
		size--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new NodeIterator();
	}

	private class Node {
		private Node prev;
		private Item item;

		public Node(Item item, Node prev) {
			this.item = item;
			this.prev = prev;
		}
	}

	private class NodeIterator implements Iterator<Item> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.prev;
			return item;
		}
	}
}
