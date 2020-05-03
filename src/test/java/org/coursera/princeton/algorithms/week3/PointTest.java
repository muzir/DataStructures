package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {
	Point p0 = new Point(0, 0);
	Point p1 = new Point(0, 0);
	Point p2 = new Point(0, 1);
	Point p3 = new Point(1, 1);
	Point p4 = new Point(1, 2);
	Point p5 = new Point(2, 4);

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

	@Test
	void returnPositiveZero_ifPointsAreHorizontallyAligned() {
		assertEquals(0, p2.slopeTo(p3));
	}

	@Test
	void returnPositiveInfinity_ifPointsAreVerticallyAligned() {
		assertEquals(POSITIVE_INFINITY, p3.slopeTo(p4));
	}

	@Test
	void returnNegativeInfinity_ifPointsAreSame() {
		assertEquals(NEGATIVE_INFINITY, p4.slopeTo(p4));
	}

	@Test
	void returnDecimalSlopeValue_ifPointsHaveASlope() {
		assertEquals(2.0d, p4.slopeTo(p5));
	}

	@Test
	void sortBySlopeOrder() {
		Point[] points = {p0, p1, p2, p3, p4, p5};
		System.out.println(Arrays.toString(points));
		Arrays.sort(points, p5.slopeOrder());
		System.out.println(Arrays.toString(points));
	}
}
