package org.coursera.princeton.algorithms;

import java.util.Arrays;
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
		IntStream.range(0, connections.length).forEach(c -> connections[c] = c);
		IntStream.range(0, weights.length).forEach(c -> weights[c] = 1);
	}

	@Override
	public void union(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		if (pRoot == qRoot) {
			return;
		}
		if (weights[pRoot] > weights[qRoot]) {
			connections[qRoot] = pRoot;
			weights[pRoot] = weights[pRoot] + weights[qRoot];
		} else {
			connections[pRoot] = qRoot;
			weights[qRoot] = weights[qRoot] + weights[pRoot];
		}
	}

	@Override
	public boolean connected(int p, int q) {
		int pRoot = findRoot(p);
		int qRoot = findRoot(q);
		if (pRoot == qRoot) {
			System.out.println("pRoot:" + pRoot + " qRoot:" + qRoot);
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

	public String toString() {
		return Arrays.toString(connections);
	}
}
