package linkedin._349_Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class TwoLineSolution implements Solution {
  @Override
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return new int[0];
    }
    final Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
  }
}
