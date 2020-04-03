package org.coursera.princeton.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UnionFindTest {

	private UnionFind unionFind = new UnionFind(10);

	@Test
	void unionTest() {
		unionFind.union(0, 5);
		Assertions.assertTrue(unionFind.hasConnection(0, 5), "failed");
	}
}
