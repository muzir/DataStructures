package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {
	Point p0 = new Point(0, 0);
	Point p1 = new Point(0, 0);
	Point p2 = new Point(0, 1);
	Point p3 = new Point(1, 1);

	@Test
	void assertPointsAreSame() {
		assertTrue(p0.compareTo(p1) == 0);
	}

	@Test
	void assertPointIsLessThanParameterPoint() {
		assertTrue(p0.compareTo(p2) == -1);
	}

	@Test
	void assertPointsHorizontallyAlignedButVerticallyFirstIsLessThanParameterPoint() {
		assertTrue(p2.compareTo(p3) == -1);
	}

	@Test
	void assertPointGreaterThanParameterPoint() {
		assertTrue(p3.compareTo(p0) == 1);
	}
}
