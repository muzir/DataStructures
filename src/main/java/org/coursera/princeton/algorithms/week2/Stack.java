package org.coursera.princeton.algorithms.week2;

public interface Stack<V> {
	void push(V item);

	V pop();

	boolean isEmpty();

	int size();
}
