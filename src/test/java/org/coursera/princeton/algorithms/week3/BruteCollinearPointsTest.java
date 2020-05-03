package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BruteCollinearPointsTest {
	@Test
	void throwIllegalArgumentException_ifArgumentNull() {
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(null));
	}

	@Test
	void throwIllegalArgumentException_ifAnyPointInTheArgumentsIsNull() {
		Point[] points = {null, new Point(0, 0), new Point(0, 1)};
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(points));
	}

	@Test
	void throwIllegalArgumentException_ifIsThereAnyDuplicatePointInTheArguments() {
		Point[] points = {new Point(0, 1), new Point(0, 0), new Point(0, 1)};
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(points));
	}
}
