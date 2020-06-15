package org.coursera.princeton.algorithms.week4;

import org.junit.jupiter.api.Test;

class OrderedPriorityQueueTest {
	Queue<Character> underTest = new OrderedPriorityQueue(10);

	@Test
	void insertSuccessfully() {
		underTest.insert(Character.valueOf('C'));
		underTest.insert(Character.valueOf('B'));
		underTest.insert(Character.valueOf('A'));
		System.out.println(underTest.toString());
	}
}
