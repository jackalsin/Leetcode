package _301_350._350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int ptr1 = 0, ptr2 = 0;
    final List<Integer> res = new ArrayList<>();
    while (ptr1 < nums1.length && ptr2 < nums2.length) {
      if (nums1[ptr1] < nums2[ptr2]) {
        ++ptr1;
      } else if (nums1[ptr1] > nums2[ptr2]) {
        ++ptr2;
      } else {
        res.add(nums1[ptr1]);
        ++ptr1;
        ++ptr2;
      }
    }
    final int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); ++i) {
      result[i] = res.get(i);
    }
    return result;
  }
}
