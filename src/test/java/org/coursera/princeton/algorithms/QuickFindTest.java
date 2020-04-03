package org.coursera.princeton.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class QuickFindTest {

	private Connectivity quickFind = new QuickFind(10);

	@Test
	void returnTrue_ifNodesHasConnection() {
		quickFind.union(0, 5);
		System.out.println(quickFind);
		Assertions.assertTrue(quickFind.find(0, 5), "failed");
	}
}
