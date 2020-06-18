package org.coursera.princeton.algorithms.week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderedPriorityQueueTest {
	Queue<Character> underTest;

	@BeforeEach
	void setUp() {
		underTest = new OrderedPriorityQueue(10);
	}

	@Test
	void returnMaxCharacter_whenCallDeleteMax() {
		givenCharacterSample();
		Character maxKey = deleteMax();
		assertKeyEqualToMaxCharacterSample(maxKey);
	}

	@Test
	void shouldThrowQueueFullException_ifQueueIsFull() {
		underTest = new OrderedPriorityQueue<>(1);
		underTest.insert(Character.valueOf('A'));
		Assertions.assertThrows(QueueFullException.class, () ->
				underTest.insert(Character.valueOf('A'))
		);
	}

	private void assertKeyEqualToMaxCharacterSample(Character character) {
		character.equals(Character.valueOf('C'));
	}

	private Character deleteMax() {
		return underTest.delMax();
	}

	private void givenCharacterSample() {
		underTest.insert(Character.valueOf('C'));
		underTest.insert(Character.valueOf('B'));
		underTest.insert(Character.valueOf('A'));
	}
}
