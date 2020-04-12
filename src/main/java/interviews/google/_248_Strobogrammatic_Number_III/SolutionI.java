package interviews.google._248_Strobogrammatic_Number_III;

import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> MAP = Map.of(
      1, 1,
      8, 8,
      0, 0,
      6, 9,
      9, 6
  );

  public int strobogrammaticInRange(String low, String high) {
    return strobogrammaticInRange(low, high, "");
  }

  private static int strobogrammaticInRange(final String low, final String high, final String s) {
    if (isInRange(low, high, s) > 0) {
      return 0;
    }
    int count = 0;
    if (isInRange(low, high, s) == 0) {
      count++;
    }
    if (s.isEmpty()) {
      count += strobogrammaticInRange(low, high, "0")
          + strobogrammaticInRange(low, high, "1")
          + strobogrammaticInRange(low, high, "8");
    }
    for (final var e : MAP.entrySet()) {
      final int left = e.getKey(), right = e.getValue();
      final String next = left + s + right;
      count += strobogrammaticInRange(low, high, next);
    }
    return count;
  }

  private static int isInRange(final String low, final String high, final String cur) {
    if (cur.length() < low.length()) {
      return -1;
    }
    if (high.length() < cur.length()) {
      return 1;
    }
    final int lowCmp = low.compareTo(cur),
        highCmp = cur.compareTo(high);
    if (lowCmp < 0) {
      return -1;
    }
    if (highCmp > 0) {
      return 1;
    }
    return 0;
  }
}
