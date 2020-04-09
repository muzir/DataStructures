package org.coursera.princeton.algorithms;

import java.util.stream.IntStream;

public class WeightedQuickUnion implements Connectivity {
	private final int[] connections;
	private final int[] weights;

	public WeightedQuickUnion(int n) {
		this.connections = new int[n];
		this.weights = new int[n];
		initialize();
	}

	private void initialize() {
		IntStream.range(0, connections.length - 1).forEach(c -> connections[c] = c);
		IntStream.range(0, weights.length - 1).forEach(c -> connections[c] = 1);
	}

	@Override
	public void union(int p, int q) {
		int pWeight = weights[p];
		int qWeights = weights[q];
		if (pWeight > qWeights) {
			connections[q] = p;
			weights[p] = weights[p] + weights[q];
		} else {
			connections[p] = q;
			weights[q] = weights[q] + weights[p];
		}
	}

	@Override
	public boolean connected(int p, int q) {
		if (findRoot(p) == findRoot(q)) {
			return true;
		}
		return false;
	}

	private int findRoot(int valueIndex) {
		int value = connections[valueIndex];
		if (value == valueIndex) {
			return value;
		}
		return findRoot(value);
	}
}
