package org.coursera.princeton.algorithms.week2;

import java.util.Iterator;

public interface RandomizedDeque<Item> extends Iterable<Item> {

	// is the randomized queue empty?
	boolean isEmpty();

	// return the number of items on the randomized queue
	int size();

	// add the item
	void enqueue(Item item);

	// remove and return a random item
	Item dequeue();

	// return a random item (but do not remove it)
	Item sample();

	// return an independent iterator over items in random order
	Iterator<Item> iterator();
}
