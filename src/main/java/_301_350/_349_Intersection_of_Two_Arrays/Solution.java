package _301_350._349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class Solution {

  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1.length < nums2.length) {
      return intersectionSmaller(nums1, nums2);
    } else {
      return intersectionSmaller(nums2, nums1);
    }
  }

  private int[] intersectionSmaller(int[] nums1, int[] nums2) {
    Set<Integer> visited = new HashSet<>();
    for (int i : nums1) {
      visited.add(i);
    }
    Set<Integer> interset = new HashSet<>();
    for (int j : nums2) {
      if (visited.contains(j)) {
        interset.add(j);
      }
    }
    final int[] result = new int[interset.size()];
    int i = 0;
    for (int element : interset) {
      result[i++] = element;
    }
    return result;
  }
}
