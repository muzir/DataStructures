package org.coursera.princeton.algorithms.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackClientTest {

	StackClient stackClient = new StackClient();

	@Test
	public void generateStackedOutputBasedOnHyphen() {
		String message = "to be or not to - be - - that - - - is";
		assertEquals("to be not that or be", stackClient.generate(message));
	}
}
