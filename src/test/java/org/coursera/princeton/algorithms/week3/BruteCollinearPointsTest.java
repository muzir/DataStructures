package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BruteCollinearPointsTest {
	/*
	*
	*
	10000      0
    0  10000
 3000   7000
 7000   3000
20000  21000
 3000   4000
14000  15000
 6000   7000
	*
	* */
	@Test
	void test2() {
		Point[] points = {new Point(10000, 0), new Point(0, 10000), new Point(3000, 7000),
				new Point(7000, 3000), new Point(20000, 21000), new Point(3000, 4000),
				new Point(14000, 15000), new Point(6000, 7000)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		System.out.println(Arrays.toString(bruteCollinearPoints.segments()));
		assertEquals(4, bruteCollinearPoints.segments().length);

	}

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

	@Test
	void test() {
		Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		System.out.println(Arrays.toString(bruteCollinearPoints.segments()));
		assertEquals(1, bruteCollinearPoints.segments().length);
	}

	@Test
	void test1() {
		Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4),
				new Point(5, 3), new Point(6, 3), new Point(7, 3), new Point(8, 3)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		System.out.println(Arrays.toString(bruteCollinearPoints.segments()));
		assertEquals(2, bruteCollinearPoints.segments().length);
	}
}
