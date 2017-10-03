package _301_350._332_Reconstruct_Itinerary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/1/2017.
 */
public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, Set<String>> fromToMapping = new HashMap<>();
    for (String[] it : tickets) {
      fromToMapping.putIfAbsent(it[0], new HashSet<>());
      fromToMapping.get(it[0]).add(it[1]);
    }
    return null;
  }
}
