package org.coursera.princeton.algorithms.week3;

import java.util.Arrays;

public class FastCollinearPoints {

	private final Point[] points;
	private LineSegment[] lineSegments = new LineSegment[0];

	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		validatePoints(points);
		this.points = Arrays.copyOf(points, points.length);
		fillLineSegments();
	}

	private void fillLineSegments() {
		int pointsLength = points.length;
		int incrementalCount = 1;
		for (int i = 0; i < pointsLength; i = i + incrementalCount) {
			Point p = points[i];
			Arrays.sort(points, p.slopeOrder());
			double slope = 0.0;
			for (int j = i + 1; j < pointsLength; j++) {
				Point q = points[j];
				double pq = p.slopeTo(q);
				if (pq == slope) {
					continue;
				} else if ((slope == 0) && (pq != slope)) {
					slope = pq;
				} else {
					incrementalCount = (j - i);
					if (incrementalCount >= 4) {
						addSegments(points[i], points[j]);
					}
				}
			}
		}
	}

	private void addSegments(Point point, Point point1) {
		LineSegment lineSegment = new LineSegment(point, point1);
		int segmentsCount = numberOfSegments();
		segmentsCount++;
		LineSegment[] newLineSegments = Arrays.copyOf(lineSegments, segmentsCount);
		newLineSegments[segmentsCount - 1] = lineSegment;
		lineSegments = newLineSegments;
	}

	private void validatePoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}
		nullAndDuplicatePointCheck(points);
	}

	private void nullAndDuplicatePointCheck(Point[] points) {
		int pointsLength = points.length;
		for (int i = 0; i < pointsLength; i++) {
			Point outerPoint = points[i];
			for (int j = 0; j < pointsLength; j++) {
				Point innerPoint = points[j];
				if (innerPoint == null) {
					throw new IllegalArgumentException();
				}
				if (i == j) {
					continue;
				}
				if (outerPoint.compareTo(innerPoint) == 0) {
					throw new IllegalArgumentException();
				}
			}
		}
	}

	// the number of line segments
	public int numberOfSegments() {
		return lineSegments.length;
	}

	// the line segments
	public LineSegment[] segments() {
		return Arrays.copyOf(lineSegments, lineSegments.length);
	}
}
