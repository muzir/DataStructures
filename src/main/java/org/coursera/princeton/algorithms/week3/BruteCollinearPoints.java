package org.coursera.princeton.algorithms.week3;

import java.util.Arrays;

public class BruteCollinearPoints {

	private final Point[] points;
	private LineSegment[] segments = new LineSegment[0];


	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		validatePoints(points);
		this.points = Arrays.copyOf(points, points.length);
		fillSegments();
	}

	private void fillSegments() {
		int pointLength = points.length;
		for (int p = 0; p < pointLength; p++) {
			Point pointP = points[p];
			for (int q = p; q < pointLength; q++) {
				Point pointQ = points[q];
				for (int r = q; r < pointLength; r++) {
					Point pointR = points[r];
					for (int s = r; s < pointLength; s++) {
						Point pointS = points[s];
						if (checkCollinear(pointP, pointQ, pointR, pointS)) {
							Point[] tempPoints = {pointP, pointQ, pointR, pointS};
							Arrays.sort(tempPoints);
							addSegments(tempPoints[tempPoints.length - 1], tempPoints[0]);
						}
					}
				}
			}
		}
	}

	private void addSegments(Point point, Point point1) {
		LineSegment lineSegment = new LineSegment(point, point1);
		int segmentsCount = numberOfSegments();
		segmentsCount++;
		LineSegment[] newLineSegments = Arrays.copyOf(segments, segmentsCount);
		newLineSegments[segmentsCount - 1] = lineSegment;
		segments = newLineSegments;
	}

	private boolean checkCollinear(Point pointP, Point pointQ, Point pointR, Point pointS) {
		if (pointP.compareTo(pointQ) == 0 ||
				pointP.compareTo(pointR) == 0 ||
				pointP.compareTo(pointS) == 0 ||
				pointQ.compareTo(pointR) == 0 ||
				pointQ.compareTo(pointS) == 0 ||
				pointR.compareTo(pointS) == 0) {
			return false;
		}
		double pQ = pointP.slopeTo(pointQ);
		double pR = pointP.slopeTo(pointR);
		double pS = pointP.slopeTo(pointS);
		return (pQ == pR) && (pQ == pS);
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
		return segments().length;
	}

	// the line segments
	public LineSegment[] segments() {
		return Arrays.copyOf(segments, segments.length);
	}
}
