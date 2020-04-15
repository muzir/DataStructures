package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FixedCapacityStackOfStringsTest {

	Stack<String> stack = new FixedCapacityStackOfStrings(10);

	@Test
	public void returnLatestItem_ifItemPopFromStack() {
		stack.push("item");
		assertEquals("item", stack.pop());
	}

	@Test
	public void returnLatestItem_ifMultipleItemsPushedAndPopToStack() {
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		assertEquals("item3", stack.pop());
		assertEquals("item2", stack.pop());
		assertEquals("item1", stack.pop());
	}

	@Test
	public void throwEmptyStackException_ifPopCalledWhenStackIsEmpty() {
		assertThrows(EmptyStackException.class, () -> {
			stack.pop();
		});
	}
}
