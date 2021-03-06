package org.algorithms.fundamentals.dataabstraction;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Exercise3Test {

	Exercise3 underTest = new Exercise3();

	static Stream<Arguments> intervalsBoundariesProvider() {
		double[] expectedValues = {0.0, 2.0, 4.0, 6.0, 8.0};
		return Stream.of(Arguments.of(5, 0.0, 10.0, expectedValues));
	}

	@ParameterizedTest
	@MethodSource("intervalsBoundariesProvider")
	void shouldSeriesUniformDistributed(int n, double min, double max, double[] expectedValues) {
		assertArrayEquals(expectedValues, underTest.findUniformDistributedValues(n, min, max));
	}
}
