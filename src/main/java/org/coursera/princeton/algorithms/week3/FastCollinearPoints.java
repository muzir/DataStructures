package org.coursera.princeton.algorithms.week3;

import java.util.Arrays;

public class FastCollinearPoints {

	private final Point[] points;
	private LineSegment[] lineSegments = new LineSegment[0];

	private Point[] startPoints;
	private Point[] endPoints;

	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		validatePoints(points);
		startPoints = new Point[points.length];
		endPoints = new Point[points.length];
		this.points = Arrays.copyOf(points, points.length);
		fillLineSegments();
	}

	private void fillLineSegments() {
		int pointsLength = this.points.length;
		for (int i = 0; i < pointsLength; i++) {
			Point p = this.points[i];
			Point[] copyPoints = Arrays.copyOf(this.points, this.points.length);
			Arrays.sort(copyPoints, p.slopeOrder());
			double slope = 0.0;
			for (int j = 1; j < pointsLength; j++) {
				Point q = copyPoints[j];
				double pq = p.slopeTo(q);
				if (pq == slope) {
					continue;
				} else if ((slope == 0) && (pq != slope)) {
					slope = pq;
				} else {
					if (j >= 4) {
						addSegments(copyPoints, j);
						break;
					}
					slope = 0.0;
				}
			}
		}
	}


	private void addSegments(Point[] points, int j) {
		Point[] newArray = Arrays.copyOf(points, j);
		Arrays.sort(newArray);
		Point startPoint = newArray[0];
		Point endPoint = newArray[newArray.length - 1];
		for (int i = 0; i < startPoints.length; i++) {
			if (startPoints[i] != null && startPoints[i].compareTo(startPoint) == 0) {
				if (endPoints[i] != null && endPoints[i].compareTo(endPoint) == 0) {
					return;
				}
			} else if (startPoints[i] == null) {
				startPoints[i] = startPoint;
				endPoints[i] = endPoint;
				break;
			}
		}
		LineSegment lineSegment = new LineSegment(startPoint, endPoint);
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
