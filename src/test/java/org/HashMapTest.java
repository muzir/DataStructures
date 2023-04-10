package org;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {
    @Test
    void foo() {
        List<Integer> scores = List.of(6, 12, 14, 8, 12, 14, 6, 8, 12, 11, 12, 14, 8, 11, 14, 3, 6, 11, 6, 12, 14);
        assertEquals(21, scores.size());
        Map<Integer, List<Integer>> scoreListMap = scores.stream().collect(groupingBy(i -> i));
        Map<Integer, Integer> scoreCounterMap = scoreListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
        System.out.println(scoreCounterMap);
    }
}
