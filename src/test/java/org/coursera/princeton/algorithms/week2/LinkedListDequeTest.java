package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDequeTest {

	Deque<String> linkedListDeque;

	@BeforeEach
	void setup() {
		linkedListDeque = new LinkedListDeque<String>();
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


	@Test
	void returnItemByIterator_ifAddFirstItemToDeque() {
		String item = "item1";
		linkedListDeque.addFirst(item);
		assertItemAddedFirstOfDeque(item);
	}

	private void assertItemAddedFirstOfDeque(String item) {
		assertTrue(linkedListDeque.iterator().hasNext());
		assertEquals(1, linkedListDeque.size());
		assertEquals(item, linkedListDeque.iterator().next());
	}

	@Test
	void returnSizeZero_ifRemoveFirstItemFromDeque() {
		String item = "item1";
		linkedListDeque.addFirst(item);
		assertEquals(item, linkedListDeque.iterator().next());
		assertEquals(1, linkedListDeque.size());

		String item1 = linkedListDeque.removeFirst();
		assertEquals(item, item1);
		assertDequeIsEmpty();
	}

	@Test
	void returnSizeOne_ifAddLastAnItemToDeque() {
		String item = "Item2";
		linkedListDeque.addLast(item);
		assertTrue(linkedListDeque.size() == 1);
	}

	@Test
	void returnItem_ifRemoveLastFromDeque() {
		String item = "item";
		linkedListDeque.addLast(item);
		assertTrue(linkedListDeque.size() == 1);

		String actualItem = linkedListDeque.removeLast();
		assertEquals(item, actualItem);
		assertDequeIsEmpty();
	}

	@Test
	void randomHunderedInsertionWithAddLastAndDeletionWithRemoveFirst() {
		String item = "item";
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.addLast(item + i);
		});
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.removeFirst();
		});
	}

	@Test
	void randomHunderedInsertionWithAddLastAndDeletionWithRemoveLast() {
		String item = "item";
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.addLast(item + i);
		});
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.removeLast();
		});
	}

	@Test
	void randomHunderedInsertionWithAddFirstAndDeletionWithRemoveLast() {
		String item = "item";
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.addFirst(item + i);
		});
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.removeLast();
		});
	}

	@Test
	void randomHunderedInsertionWithAddFirstAndDeletionWithRemoveFirst() {
		String item = "item";
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.addFirst(item + i);
		});
		IntStream.range(0, 100).forEach(i -> {
			linkedListDeque.removeFirst();
		});
	}

	private void assertDequeIsEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			linkedListDeque.iterator().next();
		});
		assertEquals(0, linkedListDeque.size());
		assertTrue(linkedListDeque.isEmpty());
	}
}
