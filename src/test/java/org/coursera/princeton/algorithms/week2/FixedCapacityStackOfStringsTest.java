package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	public void returnSizeAsOne_ifPushAnItemToStack() {
		stack.push("item");
		assertTrue(stack.size() == 1);
	}

	@Test
	public void returnSizeAsZero_ifPopCalledAfterPushOneItem() {
		stack.push("item");
		stack.pop();
		assertTrue(stack.size() == 0);
	}

	@Test
	public void resizeToDouble_ifStackReachItsCapacity() {
		IntStream.range(0, 40).forEach(i -> stack.push(String.valueOf(i)));
		assertTrue(stack.size() == 40);
	}

	@Test
	public void resizeToHalf_ifStackSizeReducedOneOfFour() {
		IntStream.range(0, 40).forEach(i -> stack.push(String.valueOf(i)));
		IntStream.range(0, 30).forEach(i -> stack.pop());
		assertTrue(stack.size() == 10);
	}
}
