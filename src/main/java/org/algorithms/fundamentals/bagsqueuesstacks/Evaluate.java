package org.algorithms.fundamentals.bagsqueuesstacks;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import static edu.princeton.cs.algs4.StdOut.println;

public class Evaluate {
	public static void main(String[] args) {
		Stack<String> operators = new Stack<>();
		Stack<Double> operands = new Stack();
		while (!StdIn.isEmpty()) {
			String parameter = StdIn.readString();
			if (parameter.equals("+")) operators.push(parameter);
			else if (parameter.equals("-")) operators.push(parameter);
			else if (parameter.equals("*")) operators.push(parameter);
			else if (parameter.equals("/")) operators.push(parameter);
			else if (parameter.equals(")")) {
				String operator = operators.pop();
				Double firstArgument = operands.pop();
				Double secondArgument = operands.pop();
				Double result = evaluate(firstArgument, secondArgument, operator);
				operands.push(result);
			} else if (!parameter.equals("(")) {
				operands.push(Double.valueOf(parameter));
			}
		}
		String result = String.format("Result: %.2f", operands.pop());
		println(result);
	}

	private static Double evaluate(Double firstArgument, Double secondArgument, String operator) {
		if (operator.equals("+")) return secondArgument + firstArgument;
		if (operator.equals("-")) return secondArgument - firstArgument;
		if (operator.equals("*")) return secondArgument * firstArgument;
		if (operator.equals("/")) return secondArgument / firstArgument;
		String exceptionMessage = String.format("Operator:%s is unknown", operator);
		throw new UnsupportedOperationException(exceptionMessage);
	}
}
