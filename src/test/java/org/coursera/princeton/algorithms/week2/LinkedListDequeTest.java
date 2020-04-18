package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class LinkedListDequeTest {

	Deque linkedListDeque;

	@BeforeEach
	void setup() {
		linkedListDeque = new LinkedListDeque();
	}

	@Test
	void throwIllegalArgumentException_ifAddFirstParameterIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			linkedListDeque.addFirst(null);
		});
	}

	@Test
	void throwIllegalArgumentException_ifAddLastParameterIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			linkedListDeque.addLast(null);
		});
	}

	@Test
	void throwNoSuchElementException_ifDequeEmptyAndRemoveFirstCalled() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			linkedListDeque.removeFirst();
		});
	}

	@Test
	void throwNoSuchElementException_ifDequeEmptyAndRemoveLastCalled() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			linkedListDeque.removeLast();
		});
	}

	@Test
	void throwUnsupportedOperationException_ifIteratorRemoveCalled() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			linkedListDeque.iterator().remove();
		});
	}

	@Test
	void throwNoSuchElementException_ifIteratorNextDoesnotHaveAnyNextItem() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			linkedListDeque.iterator().next();
		});
	}
}
