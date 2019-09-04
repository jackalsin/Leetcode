package interviews.linkedin._349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SetSolutionII implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return null;
    }
    final Set<Integer> visited = new HashSet<>();
    for (int num : nums1) {
      visited.add(num);
    }
    final Set<Integer> result = new HashSet<>();
    for (int num : nums2) {
      if (visited.contains(num)) {
        result.add(num);
      }
    }
    return getArray(result);
  }

  private static int[] getArray(final Set<Integer> list) {
    final int[] res = new int[list.size()];
    int i = 0;
    for (int n : list) {
      res[i++] = n;
    }
    return res;
  }
}
