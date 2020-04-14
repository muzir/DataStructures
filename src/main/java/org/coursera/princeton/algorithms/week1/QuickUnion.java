package org.coursera.princeton.algorithms.week1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickUnion implements Connectivity {

	private final int[] connections;

	public QuickUnion(int n) {
		connections = new int[n];
		initializeConnections();
	}

	private void initializeConnections() {
		IntStream.range(0, connections.length).forEach(c -> connections[c] = c);
	}

	@Override
	public void union(int p, int q) {
		int pRootIndex = findRoot(p);
		int qRootIndex = findRoot(q);
		connections[qRootIndex] = pRootIndex;
	}

	private int findRoot(int p) {
		int pRootIndex = connections[p];
		if (pRootIndex == p) {
			return pRootIndex;
		}
		return findRoot(pRootIndex);
	}

	@Override
	public boolean connected(int p, int q) {
		int pRootIndex = findRoot(p);
		int qRootIndex = findRoot(q);
		System.out.println("pRootIndex:" + pRootIndex + ", qRootIndex:" + qRootIndex);
		return pRootIndex == qRootIndex;
	}

	public String toString() {
		return Arrays.toString(connections);
	}
}
