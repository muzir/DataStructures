package org.coursera.princeton.algorithms.week3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FastCollinearPointsTest {

	@Test
	void throwIllegalArgumentException_ifConstructorArgumentIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new FastCollinearPoints(null);
		});
	}

	@Test
	void throwIllegalArgumentException_ifAnyArrayElementIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] points = {new Point(0, 0), null};
			new FastCollinearPoints(points);
		});
	}

	@Test
	void throwIllegalArgumentException_ifArrayContainsRepeatedElement() {
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] points = {new Point(0, 0),
					new Point(0, 1),
					new Point(0, 2),
					new Point(0, 3),
					new Point(0, 4),
					new Point(0, 0)};
			new FastCollinearPoints(points);
		});
	}

	@Test
	@Disabled
	void test_input8FileScenario() {
		Point[] points = {new Point(10000, 0), new Point(0, 10000), new Point(3000, 7000),
				new Point(7000, 3000), new Point(20000, 21000), new Point(3000, 4000),
				new Point(14000, 15000), new Point(6000, 7000)};
		FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
		System.out.println(Arrays.toString(fastCollinearPoints.segments()));
		assertEquals(2, fastCollinearPoints.segments().length);
	}

	@Test
	@Disabled
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
		FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
		assertEquals(4, fastCollinearPoints.segments().length);
	}
}
