package _0701_0750._731_My_Calendar_II;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class BetterSolution implements Solution {
  private final TreeMap<Integer, Integer> endPointToCount = new TreeMap<>();

  public boolean book(int start, int end) {
    endPointToCount.put(start, endPointToCount.getOrDefault(start, 0) + 1);
    endPointToCount.put(end, endPointToCount.getOrDefault(end, 0) - 1);
    int count = 0;
    for (final Map.Entry<Integer, Integer> e : endPointToCount.entrySet()) {
      count += e.getValue();
      if (count > 2) {
        endPointToCount.put(start, endPointToCount.get(start) - 1);
        if (endPointToCount.get(start) == 0) {
          endPointToCount.remove(start);
        }
        endPointToCount.put(end, endPointToCount.get(end) + 1);
        if (endPointToCount.get(end) == 0) {
          endPointToCount.remove(end);
        }
        return false;
      }
    }
    return true;
  }
}
