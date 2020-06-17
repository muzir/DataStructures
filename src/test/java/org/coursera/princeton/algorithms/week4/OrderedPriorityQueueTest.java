package org.coursera.princeton.algorithms.week4;

import org.junit.jupiter.api.Test;

class OrderedPriorityQueueTest {
	Queue<Character> underTest = new OrderedPriorityQueue(10);

	@Test
	void returnMaxCharacter_whenCallDeleteMax() {
		givenCharacterSample();
		Character maxKey = deleteMax();
		assertKeyEqualToMaxCharacterSample(maxKey);
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
