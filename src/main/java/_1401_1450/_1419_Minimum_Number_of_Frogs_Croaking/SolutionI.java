package _1401_1450._1419_Minimum_Number_of_Frogs_Croaking;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private static final Map<Character, Character> PREV = Map.of(
      'r', 'c', 'o', 'r', 'a', 'o', 'k', 'a'
  );

  public int minNumberOfFrogs(String croakOfFrogs) {
    final char[] chars = croakOfFrogs.toCharArray();
    final Map<Character, Integer> expecteds = new HashMap<>();
    int count = 0, max = 0;
    for (final char c : chars) {
      if (c == 'c') {
        expecteds.put(c, expecteds.getOrDefault(c, 0) + 1);
        count++;
        max = Math.max(max, count);
      } else {
        final char prev = PREV.get(c);
        final int prevCount = expecteds.getOrDefault(prev, 0);
        if (prevCount == 0) return -1;
        if (prevCount == 1) {
          expecteds.remove(prev);
        } else {
          expecteds.put(prev, prevCount - 1);
        }
        if (c == 'k') {
          count--;
        } else {
          expecteds.put(c, expecteds.getOrDefault(c, 0) + 1);
        }
      }
    }
    if (!expecteds.isEmpty()) {
      return -1;
    }
    return max;
  }
}
