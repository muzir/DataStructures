package org.exercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapMaxElement {
	public static void main(String args[]) {
		Map<String, Integer> counterMap = new HashMap<>();
		counterMap.put("a", 4);
		counterMap.put("b", 3);
		counterMap.put("c", 2);
		counterMap.put("d", 1);

		counterMap.keySet().forEach(k -> System.out.println(counterMap.get(k)));
		counterMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue));
		counterMap.keySet().forEach(k -> System.out.println(counterMap.get(k)));
	}
}
