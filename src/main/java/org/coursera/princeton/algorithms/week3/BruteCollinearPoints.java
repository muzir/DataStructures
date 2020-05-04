package org.coursera.princeton.algorithms.week3;

import java.util.Arrays;

public class BruteCollinearPoints {

	private final Point[] points;
	private LineSegment[] segments;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		validatePoints(points);
		this.points = points;
		this.segments = new LineSegment[0];
		fillSegments();
	}

	private void fillSegments() {
		int pointLength = points.length;
		for (int p = 0; p < pointLength; p++) {
			Point pointP = points[p];
			for (int q = p + 1; q < pointLength; q++) {
				Point pointQ = points[q];
				for (int r = q + 1; r < pointLength; r++) {
					Point pointR = points[r];
					for (int s = r + 1; s < pointLength; s++) {
						Point pointS = points[s];
						if (checkCollinear(pointP, pointQ, pointR, pointS)) {
							System.out.println("p:" + p + " q:" + q + " r:" + r + " s:" + s);
							addLineSegments(new LineSegment(pointP, pointS));
						}
					}
				}
			}
		}
	}

	private void addLineSegments(LineSegment lineSegment) {
		int length = segments.length;
		length = length + 1;
		LineSegment[] newLineSegment = Arrays.copyOf(segments, length);
		for (int i = 0; i < length; i++) {
			if (newLineSegment[i] == null) {
				newLineSegment[i] = lineSegment;
				break;
			}
		}
		this.segments = newLineSegment;
	}

	private boolean checkCollinear(Point pointP, Point pointQ, Point pointR, Point pointS) {
		double pQ = pointP.slopeTo(pointQ);
		double pR = pointP.slopeTo(pointR);
		double pS = pointP.slopeTo(pointS);
		return (pQ == pR) && (pQ == pS);
	}

	private void validatePoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}
		duplicatePointCheck(points);
	}

	private void duplicatePointCheck(Point[] points) {
		int pointsLenght = points.length;
		for (int i = 0; i < pointsLenght; i++) {
			Point outerPoint = points[i];
			if (outerPoint == null) {
				throw new IllegalArgumentException();
			}
			for (int j = 0; j < pointsLenght; j++) {
				if (i == j) {
					continue;
				}
				Point innerPoint = points[j];
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
		return segments;
	}
}
