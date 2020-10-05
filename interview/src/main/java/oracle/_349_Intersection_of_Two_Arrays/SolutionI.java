package oracle._349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    final Set<Integer> result = new HashSet<>();
    final Set<Integer> nums1Set = new HashSet<>();
    for (int n : nums1) {
      nums1Set.add(n);
    }

    for (int n : nums2) {
      if (nums1Set.contains(n)) {
        result.add(n);
      }
    }
    return getArray(result);
  }

  private static int[] getArray(final Set<Integer> result) {
    final int[] res = new int[result.size()];
    {
      int i = 0;
      for (int n : result) {
        res[i++] = n;
      }
    }
    return res;
  }
}
