package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStackTest {
	private Stack<String> stack;

	@BeforeEach
	public void setUp() {
		stack = new LinkedListStack();
	}

	@Test
	public void returnLastAddedItem_ifPopFromStack() {
		stack.push("item");
		assertEquals("item", stack.pop());
	}

	@Test
	public void returnSizeOne_ifPushAnItem() {
		assertStackIsEmpty();
		stack.push("item");
		assertStackIsNotEmpty();
		assertEquals(1, stack.size());
	}

	@Test
	public void returnSizeTen_ifPushTenItem() {
		IntStream.range(0, 10).forEach(c -> stack.push(String.valueOf(c)));
		assertEquals(10, stack.size());
	}

	@Test
	public void returnLastAddedItem_ifPushMultipleItems() {
		IntStream.range(0, 10).forEach(c -> stack.push(String.valueOf(c)));
		assertEquals("9", stack.pop());
	}

	@Test
	public void returnNextItem_ifPopMultipleItems() {
		IntStream.range(0, 10).forEach(c -> stack.push(String.valueOf(c)));
		assertMultipleStackPops();
		assertStackIsEmpty();
	}

	@Test
	public void throwRuntimeExceptionInPop_ifStackIsEmpty() {
		EmptyStackException exception = assertThrows(EmptyStackException.class, () -> {
			stack.pop();
		});
	}

	private void assertMultipleStackPops() {
		assertEquals("9", stack.pop());
		assertEquals("8", stack.pop());
		assertEquals("7", stack.pop());
		assertEquals("6", stack.pop());
		assertEquals("5", stack.pop());
		assertEquals("4", stack.pop());
		assertEquals("3", stack.pop());
		assertEquals("2", stack.pop());
		assertEquals("1", stack.pop());
		assertEquals("0", stack.pop());
		assertEquals(0, stack.size());
	}

	private void assertStackIsNotEmpty() {
		assertFalse(stack.isEmpty());
		assertTrue(stack.size() > 0);
	}

	private void assertStackIsEmpty() {
		assertTrue(stack.isEmpty());
	}
}
