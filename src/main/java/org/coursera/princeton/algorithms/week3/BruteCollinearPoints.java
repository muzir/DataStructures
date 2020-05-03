package org.coursera.princeton.algorithms.week3;

public class BruteCollinearPoints {

	private Point[] points;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		validate(points);
		this.points = points;
	}

	private void validate(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}
		for (Point p : points) {
			if (p == null) {
				throw new IllegalArgumentException();
			}
		}
	}

	// the number of line segments
	public int numberOfSegments() {
		return 0;
	}

	// the line segments
	public LineSegment[] segments() {
		return null;
	}
}
