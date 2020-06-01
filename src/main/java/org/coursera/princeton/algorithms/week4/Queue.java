package org.coursera.princeton.algorithms.week4;

public interface Queue<Key extends Comparable<Key>> {
	void insert(Key key);

	Key delMax();

	boolean isEmpty();

}
