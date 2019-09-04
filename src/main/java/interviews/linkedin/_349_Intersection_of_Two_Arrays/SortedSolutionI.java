package interviews.linkedin._349_Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SortedSolutionI implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return null;
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
      while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) ++i;
      while (j + 1 < nums2.length && nums2[j + 1] == nums2[j]) ++j;
      if (nums1[i] == nums2[j]) {
        result.add(nums1[i]);
        ++j;
        ++i;
      } else if (nums1[i] < nums2[j]) {
        ++i;
      } else {
        ++j;
      }
    }
    return getArray(result);
  }

  private static int[] getArray(final List<Integer> source) {
    final int[] result = new int[source.size()];
    for (int i = 0; i < source.size(); ++i) {
      result[i] = source.get(i);
    }
    return result;
  }
}
