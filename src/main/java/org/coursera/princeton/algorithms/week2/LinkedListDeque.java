package org.coursera.princeton.algorithms.week2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<Item> implements Deque<Item> {

	private Node<Item> first;
	private Node<Item> last;
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
		if (size == 0) {
			Node newNode = new Node.Builder().item(item).build();
			last = newNode;
			first = newNode;
		} else {
			Node newNode = new Node.Builder().item(item).prev(first).build();
			first.next = newNode;
			first = newNode;
		}
		size++;
	}

	@Override
	public void addLast(Item item) {
		validateNullCheck(item);
		if (size == 0) {
			Node newNode = new Node.Builder().item(item).build();
			first = newNode;
			last = newNode;
		} else {
			Node newNode = new Node.Builder().item(item).next(last).build();
			last.prev = newNode;
			last = newNode;
		}
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
		if (first.prev != null) {
			first.prev.next = null;
		}
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
		if (last.next != null) {
			last.next.prev = null;
		}
		last = last.next;
		size--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new NodeIterator();
	}

	static class Node<Item> {
		private Node prev;
		private Node next;
		private Item item;

		private Node(Builder<Item> builder) {
			this.item = builder.item;
			this.prev = builder.prev;
			this.next = builder.next;
		}

		static class Builder<Item> {
			private Node prev;
			private Node next;
			private Item item;

			public Builder prev(Node prev) {
				this.prev = prev;
				return this;
			}

			public Builder next(Node next) {
				this.next = next;
				return this;
			}

			public Builder item(Item item) {
				this.item = item;
				return this;
			}

			public Node build() {
				return new Node(this);
			}
		}
	}

	private class NodeIterator<Item> implements Iterator<Item> {

		private Node<Item> current;

		public NodeIterator() {
			this.current = (Node<Item>) first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.prev;
			return item;
		}
	}
}
