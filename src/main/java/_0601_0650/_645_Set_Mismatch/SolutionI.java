package _0601_0650._645_Set_Mismatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] findErrorNums(int[] nums) {
    if (nums == null) {
      return new int[2];
    }
    final Map<Integer, Integer> all = getAll(nums.length);
    for (int n : nums) {
      all.put(n, all.getOrDefault(n, 0) - 1);
      if (all.get(n) == 0) {
        all.remove(n);
      }
    }
    final int[] res = new int[2];
//    System.out.println(all);
    assert all.size() == 2;
    for (final Map.Entry<Integer, Integer> e : all.entrySet()) {
      final int key = e.getKey(), val = e.getValue();
      if (val == 1) {
        res[1] = key;
      } else if (val == -1) {
        res[0] = key;
      }
    }
    return res;
  }

  private static Map<Integer, Integer> getAll(final int length) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= length; ++i) {
      map.put(i, 1);
    }
    return map;
  }
}
