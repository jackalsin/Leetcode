package linkedin._349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SetSolutionI implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return new int[]{};
    }
    if (nums1.length > nums2.length) {
      final int[] tmp = nums2;
      nums2 = nums1;
      nums1 = tmp;
    }
    final Set<Integer> visited = new HashSet<>(),
        dup = new HashSet<>();
    for (int i : nums1) {
      visited.add(i);
    }
    for (int j : nums2) {
      if (visited.contains(j)) {
        dup.add(j);
      }
    }
    final int[] res = new int[dup.size()];
    {
      int i = 0;
      for (int j : dup) {
        res[i++] = j;
      }
    }
    return res;
  }
}
