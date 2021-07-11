package org.algorithms.fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Exercise2Test {

	private Exercise2 underTest;

	static Stream<Arguments> intervalProvider() {
		return Stream.of(arguments(List.of(new Interval1D(0, 1), new Interval1D(2, 3), new Interval1D(4, 5)),
				emptyMap()),
				arguments(List.of(new Interval1D(0, 2), new Interval1D(1, 2)),
						Map.of(new Interval1D(0, 2), Set.of(new Interval1D(1, 2)), new Interval1D(1, 2), Set.of(new Interval1D(0, 2))))
		);
	}

	@BeforeEach
	void setUp() {
		underTest = new Exercise2();
	}

	@ParameterizedTest
	@MethodSource("intervalProvider")
	void shouldFindIntersectIntervals(List<Interval1D> intervals, Map<Interval1D, Set<Interval1D>> expectedIntervals) {
		assertEquals(expectedIntervals, underTest.findIntersectPairs(intervals));
	}
}
