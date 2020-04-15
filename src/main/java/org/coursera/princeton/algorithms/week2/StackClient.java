package org.coursera.princeton.algorithms.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StackClient {
	private List<String> values = new ArrayList<>();

	public String generate(String message) {
		Stack<String> stack = new LinkedListStack();
		String[] strings = message.split(" ");
		Arrays.stream(strings).forEach(s -> {
			if (s.equals("-")) {
				values.add(stack.pop());
			} else {
				stack.push(s);
			}
		});
		return values.stream().collect(Collectors.joining(" "));
	}
}
