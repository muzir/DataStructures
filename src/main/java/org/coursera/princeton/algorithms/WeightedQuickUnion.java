package org.coursera.princeton.algorithms;

import java.util.stream.IntStream;

public class WeightedQuickUnion implements Connectivity {
	private final int[] connections;

	public WeightedQuickUnion(int n) {
		this.connections = new int[n];
		initialize(connections);
	}

	private void initialize(int[] connections) {
		IntStream.range(0, connections.length - 1).forEach(c -> connections[c] = c);
	}

	@Override
	public void union(int p, int q) {

	}

	@Override
	public boolean connected(int p, int q) {
		return false;
	}
}
