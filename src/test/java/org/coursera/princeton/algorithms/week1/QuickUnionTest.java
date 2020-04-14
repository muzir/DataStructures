package org.coursera.princeton.algorithms.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickUnionTest {

	Connectivity quickUnion = new QuickUnion(10);

	private void createConnectionTree() {
		quickUnion.union(2, 9);
		quickUnion.union(4, 9);
		quickUnion.union(3, 4);
		quickUnion.union(6, 5);
		quickUnion.union(6, 9);
	}

	@BeforeEach
	void setup() {
		createConnectionTree();
	}

	@Test
	void returnTrue_ifNodesAreConnected() {
		assertTrue(quickUnion.connected(3, 6));
		assertTrue(quickUnion.connected(3, 4));
		assertTrue(quickUnion.connected(3, 2));
		assertTrue(quickUnion.connected(2, 3));
		assertTrue(quickUnion.connected(2, 6));
		assertTrue(quickUnion.connected(2, 5));
		assertTrue(quickUnion.connected(2, 5));
	}

	@Test
	void returnFalse_ifNodesAreNotConnected() {
		assertFalse(quickUnion.connected(2, 7));
		assertFalse(quickUnion.connected(2, 8));
		assertFalse(quickUnion.connected(0, 3));
		assertFalse(quickUnion.connected(0, 1));
		assertFalse(quickUnion.connected(3, 1));
		assertFalse(quickUnion.connected(3, 0));
		assertFalse(quickUnion.connected(3, 7));
		assertFalse(quickUnion.connected(3, 8));
	}
}
