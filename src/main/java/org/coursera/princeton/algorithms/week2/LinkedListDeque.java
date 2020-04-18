package org.coursera.princeton.algorithms.week2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<Item> implements Deque<Item> {

	private Node head;
	private Node tail;
	private int size;
	private Iterator<Item> iterator;

	public LinkedListDeque() {
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public void addFirst(Item item) {
		validateNullCheck(item);
	}

	@Override
	public void addLast(Item item) {
		validateNullCheck(item);
	}

	private void validateNullCheck(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Parameter can not be null");
		}
	}

	@Override
	public Item removeFirst() {
		validateDequeIsNotEmpty();
		return null;
	}

	private void validateDequeIsNotEmpty() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
	}

	@Override
	public Item removeLast() {
		validateDequeIsNotEmpty();
		return null;
	}

	@Override
	public Iterator<Item> iterator() {
		return iterator;
	}


	private class Node {
		private Node prev;
		private Node next;
		private Item item;
	}
}
