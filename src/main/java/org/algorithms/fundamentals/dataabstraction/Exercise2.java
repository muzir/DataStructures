package org.algorithms.fundamentals.dataabstraction;

import edu.princeton.cs.algs4.Interval1D;

import java.util.*;


class Exercise2 {
	Map<Interval1D, Set<Interval1D>> findIntersectPairs(List<Interval1D> intervals) {
		Map<Interval1D, Set<Interval1D>> intersectPairs = new HashMap<>();
		intervals.forEach(outerInterval -> {
			intervals.forEach(innerInterval -> {
				if (!outerInterval.equals(innerInterval) && outerInterval.intersects(innerInterval)) {
					Set<Interval1D> interval1DSet = intersectPairs.get(outerInterval);
					if (interval1DSet == null) {
						interval1DSet = new HashSet<>();
					}
					interval1DSet.add(innerInterval);
					intersectPairs.put(outerInterval, interval1DSet);
				}
			});
		});
		return intersectPairs;
	}
}
