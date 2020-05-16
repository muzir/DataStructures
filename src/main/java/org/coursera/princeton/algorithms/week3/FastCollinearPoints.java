package org.coursera.princeton.algorithms.week3;

import edu.princeton.cs.algs4.Bag;

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
			double[] slopeToArray = new double[copyPoints.length];
			for (int k = 1; k < copyPoints.length; k++) {
				slopeToArray[k] = copyPoints[0].slopeTo(copyPoints[k]);
			}
			Bag<Integer> bag = new Bag<>();
			int counter = 0;
			for (int j = 1; j < slopeToArray.length - 1; j++) {
				double current = slopeToArray[j];
				double next = slopeToArray[j + 1];
				if (current == next) {
					bag.add(j);
					counter++;
				} else {
					if (counter >= 2) {
						bag.add(j);
						addSegments(copyPoints, bag);
					}
					bag = new Bag<>();
					counter = 0;
				}
			}
		}
	}


	private void addSegments(Point[] points, Bag<Integer> bag) {
		Point[] newArray = new Point[bag.size() + 1];
		newArray[0] = points[0];
		int counter = 1;
		for (Integer index : bag) {
			newArray[counter] = points[index];
			counter++;
		}
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
