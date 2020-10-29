package _1601_1650._1630_Arithmetic_Subarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    final List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < l.length; ++i) {
      result.add(isArithmetic(nums, l[i], r[i]));
    }
    return result;
  }

  private static boolean isArithmetic(final int[] nums, final int start, final int end) {
    if (start == end) {
      return true;
    }
    final List<Integer> cur = new ArrayList<>();
    for (int i = start; i <= end; ++i) {
      cur.add(nums[i]);
    }
    Collections.sort(cur);
    final int diff = cur.get(1) - cur.get(0);
    for (int i = 2; i < cur.size(); ++i) {
      if (cur.get(i) - cur.get(i - 1) != diff) return false;
    }
    return true;
  }
}
