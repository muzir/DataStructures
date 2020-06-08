package org.coursera.princeton.algorithms.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnorderedPriorityQueueTest {

	private UnorderedPriorityQueue underTest;

	@BeforeEach
	public void setUp() {
		underTest = new UnorderedPriorityQueue(10);
	}

	@Test
	void shouldDelMaxReturnMaxValue() {
		underTest.insert(BigDecimal.ZERO);
		underTest.insert(BigDecimal.ONE);
		underTest.insert(BigDecimal.TEN);
		assertEquals(BigDecimal.TEN, underTest.delMax());
		assertEquals(BigDecimal.ONE, underTest.delMax());
		assertEquals(BigDecimal.ZERO, underTest.delMax());
	}
}
