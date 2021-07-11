package org.algorithms.fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Exercise1Test {

	Exercise1 underTest;

	static Stream<Arguments> minPointsDistance() {
		return Stream.of(
				arguments(List.of(
						new Point2D(0, 1),
						new Point2D(0, 7),
						new Point2D(0, 20)), 6),
				arguments(List.of(
						new Point2D(0, 0),
						new Point2D(0, 50),
						new Point2D(0, 70)), 20),
				arguments(List.of(
						new Point2D(10, 0),
						new Point2D(50, 0),
						new Point2D(70, 0)), 20),
				arguments(List.of(
						new Point2D(1, 2),
						new Point2D(2, 2),
						new Point2D(4, 2)), 1));
	}

	@BeforeEach
	void setup() {
		underTest = new Exercise1();
	}

	@ParameterizedTest
	@MethodSource("minPointsDistance")
	void shouldReturnClosestDistanceBetweenPairs(List<Point2D> points, double minDistance) {
		assertEquals(minDistance, underTest.computeDistanceClosestPairOfPoints(points));
	}

	@ParameterizedTest
	@MethodSource("minPointsDistance")
	void shouldReturnClosestDistanceBetweenPairsFunctional(List<Point2D> points, double minDistance) {
		assertEquals(minDistance, underTest.computeDistanceClosestPairOfPointsFunctional(points));
	}
}
