package org.coursera.princeton.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickFind implements Connectivity {

	private final int[] connections;

	public QuickFind(int n) {
		connections = new int[n];
		initialize(connections);
	}

	private void initialize(int[] connections) {
		IntStream.range(0, connections.length).forEach(c -> connections[c] = c);
	}

	@Override
	public void union(int indexP, int indexQ) {
		int p = connections[indexP];
		int q = connections[indexQ];
		for (int i = 0; i < connections.length; i++) {
			if (connections[i] == p) {
				connections[i] = q;
			}
		}
	}

	@Override
	public boolean connected(int p, int q) {
		return connections[p] == connections[q];
	}

	public String toString() {
		return Arrays.toString(connections);
	}
}
