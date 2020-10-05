package _0901_0950._914_X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean hasGroupsSizeX(int[] deck) {
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i : deck) {
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }

    // 找最大公约数，检查其是否大于2
    int res = 0;
    for (int i : counts.values()) res = gcd(i, res);
    return res >= 2;
  }

  private static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }
    while (b > 0) {
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

}
