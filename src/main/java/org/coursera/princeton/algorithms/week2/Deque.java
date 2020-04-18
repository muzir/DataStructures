package org.coursera.princeton.algorithms.week2;

import java.util.Iterator;

public interface Deque<Item> extends Iterable<Item> {

	// is the deque empty?
	boolean isEmpty();

	// return the number of items on the deque
	int size();

	// add the item to the front
	void addFirst(Item item);

	// add the item to the back
	void addLast(Item item);

	// remove and return the item from the front
	Item removeFirst();

	// remove and return the item from the back
	Item removeLast();

	// return an iterator over items in order from front to back
	Iterator<Item> iterator();

}
