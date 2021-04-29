package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public interface Queue<V> extends Iterable<V> {
	void enqueue(V item);

	V dequeue();

	int size();

	boolean isEmpty();

	Iterator<V> iterator();
}
