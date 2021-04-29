package org.algorithms.fundamentals.bagsqueuesstacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {
	private Queue<String> queue;

	@BeforeEach
	void setup() {
		queue = new LinkedListQueue<String>();
	}

	@Test
	void shouldReturnSizeOne_whenAddedNewItem() {
		queue.enqueue("to");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}

	@Test
	void shouldReturnElement_whenPoppedFromQueue() {
		queue.enqueue("to");
		String poppedItem = queue.dequeue();
		assertEquals("to", poppedItem);
		assertTrue(queue.isEmpty());
	}

	@Test
	void shouldEnqueueAndDequeue_ifMultipleElementsEnqueuedAndDequeued() {
		IntStream.range(0, 1000).forEach(value -> queue.enqueue("to"));

		IntStream.range(0, 800).forEach(value -> queue.dequeue());
		assertEquals(200, queue.size());
	}

	@Test
	void shouldIterateQueue_ifCallForEach() {
		String[] params = {"to", "be", "or", "not"};
		queue.enqueue(params[0]);
		queue.enqueue(params[1]);
		queue.enqueue(params[2]);
		queue.enqueue(params[3]);
		int i = params.length - 1;
		for (String s : queue) {
			assertEquals(params[i--], s);
		}
	}
}
