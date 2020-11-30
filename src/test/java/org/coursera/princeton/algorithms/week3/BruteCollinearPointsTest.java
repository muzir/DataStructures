package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BruteCollinearPointsTest {

	@Test
	void test_input8FileScenario() {
		Point[] points = {new Point(10000, 0), new Point(0, 10000), new Point(3000, 7000),
				new Point(7000, 3000), new Point(20000, 21000), new Point(3000, 4000),
				new Point(14000, 15000), new Point(6000, 7000)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		assertEquals(2, bruteCollinearPoints.segments().length);
		Arrays.stream(bruteCollinearPoints.segments()).forEach(ls -> System.out.println(ls.toString()));
	}

	@Test
	void testEquidistantFileScenario() {
		Point[] points = {
				new Point(10000, 0),
				new Point(8000, 2000),
				new Point(2000, 8000),
				new Point(0, 10000),
				new Point(20000, 0),
				new Point(18000, 2000),
				new Point(2000, 18000),
				new Point(10000, 20000),
				new Point(30000, 0),
				new Point(0, 30000),
				new Point(20000, 10000),
				new Point(13000, 0),
				new Point(11000, 3000),
				new Point(5000, 12000),
				new Point(9000, 6000)
		};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		//assertEquals(2, bruteCollinearPoints.segments().length);
		Arrays.stream(bruteCollinearPoints.segments()).forEach(ls -> System.out.println(ls.toString()));
	}

	@Test
	void throwIllegalArgumentException_ifArgumentNull() {
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(null));
	}

	@Test
	void throwIllegalArgumentException_ifAnyPointInTheArgumentsIsNull() {
		Point[] points = {new Point(0, 0), null, new Point(0, 1)};
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(points));
	}

	@Test
	void throwIllegalArgumentException_ifIsThereAnyDuplicatePointInTheArguments() {
		Point[] points = {new Point(0, 1), new Point(0, 0), new Point(0, 1)};
		assertThrows(IllegalArgumentException.class, () -> new BruteCollinearPoints(points));
	}

	@Test
	void testRandomBasicScenario() {
		Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		assertEquals(1, bruteCollinearPoints.segments().length);
	}

	@Test
	void shouldPointsImmutable() {
		Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		assertEquals(1, bruteCollinearPoints.segments().length);
		LineSegment[] segments = bruteCollinearPoints.segments();
		segments = null;
		assertEquals(1, bruteCollinearPoints.segments().length);
	}

	@Test
	@Disabled
	void testRandomBasicScenario_1() {
		Point[] points = {new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4),
				new Point(5, 3), new Point(6, 3), new Point(7, 3), new Point(8, 3)};
		BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
		assertEquals(2, bruteCollinearPoints.segments().length);
	}
}
