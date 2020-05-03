package org.coursera.princeton.algorithms.week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class SampleClient {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String filePath = path + "/src/main/resources/input6.txt";
		// read the n points from a file
		In in = new In(filePath);
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}

		// draw the points
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();

		// print and draw the line segments
		/*FastCollinearPoints collinear = new FastCollinearPoints(points);
		for (LineSegment segment : collinear.segments()) {
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();*/

	}
}
