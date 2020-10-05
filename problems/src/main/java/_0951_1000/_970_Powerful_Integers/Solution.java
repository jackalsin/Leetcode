package _0951_1000._970_Powerful_Integers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<Integer> powerfulIntegers(int x, int y, int bound) {
    final Set<Integer> result = new HashSet<>();
    for (int xBase = 1; xBase > 0 && xBase < bound; xBase *= x) {
      for (int yBase = 1; yBase > 0 && xBase + yBase <= bound; yBase *= y) {
        result.add(xBase + yBase);
        if (y == 1) break;
      }
      if (x == 1) break;
    }
    return new ArrayList<>(result);
  }
}
