package org.coursera.princeton.algorithms.week3;

public class BruteCollinearPoints {

	private final Point[] points;
	private final LineSegment[] segments;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		validatePoints(points);
		this.points = points;
		this.segments = calculateSegments();
	}

	private LineSegment[] calculateSegments() {
		int pointLength = points.length;
		LineSegment[] lineSegments = new LineSegment[pointLength];
		for (int p = 0; p < pointLength; p++) {
			Point pointP = points[p];
			for (int q = p + 1; q < pointLength; q++) {
				Point pointQ = points[q];
				for (int r = q + 1; r < pointLength; r++) {
					Point pointR = points[r];
					for (int s = r + 1; s < pointLength; s++) {
						Point pointS = points[s];
						if (checkCollinear(pointP, pointQ, pointR, pointS)) {
							addLineSegments(lineSegments, new LineSegment(pointP, pointQ));
						}
					}
				}
			}
		}
		return new LineSegment[0];
	}

	private void addLineSegments(LineSegment[] lineSegments, LineSegment lineSegment) {
		int length = lineSegments.length;
		for (int i = 0; i < length; i++) {
			if (lineSegments[i] == null) {
				lineSegments[i] = lineSegment;
			}
		}
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
