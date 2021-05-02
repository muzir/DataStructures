package org.algorithms.fundamentals.bagsqueuesstacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LinkedListBagTest {
	private Bag<String> bag;

	@BeforeEach
	void setup() {
		bag = new LinkedListBag<String>();
	}

	@Test
	void shouldReturnSizeOne_whenAddedNewItem() {
		bag.add("to");
		assertEquals(1, bag.size());
		assertFalse(bag.isEmpty());
	}

	@Test
	void shouldAdd_ifMultipleElementsAdded() {
		IntStream.range(0, 1000).forEach(value -> bag.add("to"));
		assertEquals(1000, bag.size());
	}

	@Test
	void shouldIterateQueue_ifCallForEach() {
		String[] params = {"to", "be", "or", "not"};
		bag.add(params[0]);
		bag.add(params[1]);
		bag.add(params[2]);
		bag.add(params[3]);
		System.out.println(bag);
		int i = params.length-1;
		for (String s : bag) {
			assertEquals(params[i--], s);
		}
	}
}
