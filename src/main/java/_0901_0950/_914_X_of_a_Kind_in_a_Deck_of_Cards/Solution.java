package _0901_0950._914_X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i : deck) {
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }
    final Set<Integer> values = new HashSet<>(counts.values());

    return hasCommon(values);
  }

  private static boolean hasCommon(final Set<Integer> values) {
    iLoop:
    for (int i = 2; ; i++) {
      for (int c : values) {
        if (c < i) {
          return false;
        }
        if (c % i != 0) {
          continue iLoop;
        }
      }
      return true;
    }
  }
}
