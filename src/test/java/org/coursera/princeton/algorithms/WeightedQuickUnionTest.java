package org.coursera.princeton.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedweightedQuickUnionTest {

	Connectivity weightedQuickUnion = new WeightedQuickUnion(10);

	private void createConnectionTree() {
		weightedQuickUnion.union(2, 9);
		weightedQuickUnion.union(4, 9);
		weightedQuickUnion.union(3, 4);
		weightedQuickUnion.union(6, 5);
		weightedQuickUnion.union(6, 9);
	}

	@BeforeEach
	void setup() {
		createConnectionTree();
	}

	@Test
	void returnTrue_ifNodesAreConnected() {
		assertTrue(weightedQuickUnion.connected(3, 6));
		assertTrue(weightedQuickUnion.connected(3, 4));
		assertTrue(weightedQuickUnion.connected(3, 2));
		assertTrue(weightedQuickUnion.connected(2, 3));
		assertTrue(weightedQuickUnion.connected(2, 6));
		assertTrue(weightedQuickUnion.connected(2, 5));
		assertTrue(weightedQuickUnion.connected(2, 5));
	}

	@Test
	void returnFalse_ifNodesAreNotConnected() {
		assertFalse(weightedQuickUnion.connected(2, 7));
		assertFalse(weightedQuickUnion.connected(2, 8));
		assertFalse(weightedQuickUnion.connected(0, 3));
		assertFalse(weightedQuickUnion.connected(0, 1));
		assertFalse(weightedQuickUnion.connected(3, 1));
		assertFalse(weightedQuickUnion.connected(3, 0));
		assertFalse(weightedQuickUnion.connected(3, 7));
		assertFalse(weightedQuickUnion.connected(3, 8));
	}
}
