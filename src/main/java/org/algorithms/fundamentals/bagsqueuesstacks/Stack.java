package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public interface Stack<T> extends Iterable<T>{
	boolean isEmpty();

	int size();

	void push(T item);

	T pop();

	Iterator<T> iterator();
}
