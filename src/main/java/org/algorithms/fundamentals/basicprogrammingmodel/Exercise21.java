package org.algorithms.fundamentals.basicprogrammingmodel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise21 {
	public static void main(String[] args) {
		String[] lines = StdIn.readAllLines();
		StdOut.printf("name first second result \n");
		Arrays.stream(lines).forEach(line -> {
			String[] parameters = line.split(" ");
			String name = parameters[0];
			int firstInteger = Integer.parseInt(parameters[1]);
			int secondInteger = Integer.parseInt(parameters[2]);
			StdOut.printf("%s %d %d %d \n", name, firstInteger, secondInteger, firstInteger / secondInteger);
		});
	}
}
