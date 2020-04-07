package org.coursera.princeton.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WeightedQuickUnionTest {

	Connectivity weightedQuickUnion = new WeightedQuickUnion(10);

	@Test
	void returnTrue_ifNodesAreConnected() {
		weightedQuickUnion.union(0, 1);
		assertTrue(weightedQuickUnion.connected(0, 1));
	}
}
