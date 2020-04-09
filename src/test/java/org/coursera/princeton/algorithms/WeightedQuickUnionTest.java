package org.coursera.princeton.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedweightedQuickUnionTest {

	Connectivity weightedQuickUnion = new WeightedQuickUnion(10);

	private void createConnectionTree() {
		weightedQuickUnion.union(4, 3);
		weightedQuickUnion.union(3, 8);
		weightedQuickUnion.union(6, 5);
		weightedQuickUnion.union(9, 4);
		weightedQuickUnion.union(2, 1);
		weightedQuickUnion.union(5, 0);
		weightedQuickUnion.union(7, 2);
		weightedQuickUnion.union(6, 1);
		System.out.println(weightedQuickUnion.toString());
	}

	@BeforeEach
	void setup() {
		createConnectionTree();
	}

	@Test
	void returnTrue_ifNodesAreConnected() {
		assertTrue(weightedQuickUnion.connected(3, 4));
		assertTrue(weightedQuickUnion.connected(2, 6));
		assertTrue(weightedQuickUnion.connected(2, 5));
	}

	@Test
	void returnFalse_ifNodesAreNotConnected() {
		assertFalse(weightedQuickUnion.connected(3, 6));
		assertFalse(weightedQuickUnion.connected(3, 2));
		assertFalse(weightedQuickUnion.connected(2, 3));
		assertFalse(weightedQuickUnion.connected(2, 5));

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
