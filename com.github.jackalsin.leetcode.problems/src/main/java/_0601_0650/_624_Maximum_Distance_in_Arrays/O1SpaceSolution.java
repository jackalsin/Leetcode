package _0601_0650._624_Maximum_Distance_in_Arrays;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/6/2020
 */
public final class O1SpaceSolution implements Solution {
  @Override
  public int maxDistance(List<List<Integer>> arrays) {
    int res = 0, min = 10000, max = -10000;
    for (final List<Integer> a : arrays) {
      final int first = a.get(0), last = a.get(a.size() - 1);
      res = Math.max(res, Math.max(last - min, max - first));
      min = Math.min(min, first);
      max = Math.max(max, last);
    }
    return res;
  }
}
