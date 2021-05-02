package org.algorithms.fundamentals.bagsqueuesstacks;

import java.util.Iterator;

public interface Bag<V> extends Iterable<V> {
	void add(V item);

	int size();

	boolean isEmpty();

	Iterator<V> iterator();
}
