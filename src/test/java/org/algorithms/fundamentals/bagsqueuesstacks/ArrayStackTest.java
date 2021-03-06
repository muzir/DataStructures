package org.algorithms.fundamentals.bagsqueuesstacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
	private Stack<String> stack;

	@BeforeEach
	void setup() {
		stack = new ResizingArrayStack<>(10);
	}

	@Test
	void shouldReturnSizeOne_whenAddedNewItem() {
		stack.push("to");
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}

	@Test
	void shouldReturnElement_whenPoppedFromStack() {
		stack.push("to");
		String poppedItem = stack.pop();
		assertEquals("to", poppedItem);
		assertTrue(stack.isEmpty());
	}

	@Test
	void shouldResizeDouble_ifStackReachCapacity() {
		IntStream.range(0, 1000).forEach(value -> stack.push("to"));
		assertEquals(1000, stack.size());
	}

	@Test
	void shouldHalveDouble_ifStackIsQuarterOfCapacity() {
		IntStream.range(0, 1000).forEach(value -> stack.push("to"));

		IntStream.range(0, 800).forEach(value -> stack.pop());
		assertEquals(200, stack.size());
	}

	@Test
	void shouldIterateStack_ifCallForEach() {
		String[] params = {"to", "be", "or", "not"};
		stack.push(params[0]);
		stack.push(params[1]);
		stack.push(params[2]);
		stack.push(params[3]);
		int i = params.length - 1;
		for (String s : stack) {
			assertEquals(params[i--], s);
		}
	}
}
