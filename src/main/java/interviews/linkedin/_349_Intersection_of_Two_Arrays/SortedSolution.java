package interviews.linkedin._349_Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class SortedSolution implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    final Set<Integer> dup = new HashSet<>();
    for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
      if (nums1[i] == nums2[j]) {
        dup.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
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
