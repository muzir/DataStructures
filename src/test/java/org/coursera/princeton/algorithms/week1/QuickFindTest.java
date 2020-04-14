package org.coursera.princeton.algorithms.week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class QuickFindTest {

	private Connectivity quickFind = new QuickFind(10);

	@Test
	void returnTrue_ifNodesHasConnection() {
		quickFind.union(0, 5);
		quickFind.union(0, 1);
		Assertions.assertTrue(quickFind.connected(0, 5), "failed");
		Assertions.assertTrue(quickFind.connected(1, 5), "failed");
	}
}
