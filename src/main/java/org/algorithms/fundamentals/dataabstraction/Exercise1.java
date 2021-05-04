package org.algorithms.fundamentals.dataabstraction;


import edu.princeton.cs.algs4.Point2D;

import java.util.*;
import java.util.stream.IntStream;

class Exercise1 {

	double computeDistanceClosestPairOfPoints(List<Point2D> points) {

		if (points.size() < 2) {
			throw new IllegalArgumentException("Argument must be contain at least 2 points");
		}
		List<Double> pointsDistance = new ArrayList();
		for (int i = 0; i < points.size(); i++) {
			Point2D basePoint = points.get(i);
			for (int j = i + 1; j < points.size(); j++) {
				Point2D nextPoint = points.get(j);
				pointsDistance.add(basePoint.distanceTo(nextPoint));
			}
		}
		return pointsDistance.stream().min(Comparator.naturalOrder())
				.orElseThrow(() -> new IllegalStateException("Couldn't find the minimum of the distances"));
	}

	double computeDistanceClosestPairOfPointsFunctional(List<Point2D> points) {
		Set<Double> minPointsDistance = new TreeSet<>(Comparator.naturalOrder());
		IntStream.range(0, points.size()).forEach(i -> {
			Point2D point2D = points.get(i);
			OptionalDouble min = IntStream.range(i + 1, points.size())
					.mapToDouble(j -> point2D.distanceTo(points.get(j)))
					.min();
			min.ifPresent(element -> minPointsDistance.add(element));
		});
		return minPointsDistance.iterator().next();
	}
}
