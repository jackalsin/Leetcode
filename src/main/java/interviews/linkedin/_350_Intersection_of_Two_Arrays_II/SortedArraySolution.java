package interviews.linkedin._350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class SortedArraySolution implements Solution {
  @Override
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null) {
      return nums2;
    }
    if (nums2 == null) {
      return nums1;
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
      if (nums1[i] == nums2[j]) {
        result.add(nums1[i++]);
        ++j;
      } else if (nums1[i] < nums2[j]) {
        ++i;
      } else {
        ++j;
      }
    }
    final int[] res = new int[result.size()];
    for (int i = 0; i < result.size(); ++i) {
      res[i] = result.get(i);
    }
    return res;
  }
}
