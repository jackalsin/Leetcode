package _0601_0650._624_Maximum_Distance_in_Arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/5/2020
 */
public final class ONSpaceSolution implements Solution {
  @Override
  public int maxDistance(List<List<Integer>> arrays) {
    if (arrays.size() <= 1) {
      return 0;
    }
    final int size = arrays.size();
    final int[] maxExceptSelf = new int[size];
    Arrays.fill(maxExceptSelf, -10000);
    for (int i = 0, max = -10000; i < size; ++i) {
      maxExceptSelf[i] = max;
      if (!arrays.get(i).isEmpty()) {
        max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
      }
    }
    for (int i = size - 1, max = -10000; i >= 0; --i) {
      maxExceptSelf[i] = Math.max(max, maxExceptSelf[i]);
      if (!arrays.get(i).isEmpty()) {
        max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
      }
    }
    int max = 0;
    for (int i = 0; i < size; ++i) {
      max = Math.max(max, maxExceptSelf[i] - arrays.get(i).get(0));
    }
    return max;
  }
}
