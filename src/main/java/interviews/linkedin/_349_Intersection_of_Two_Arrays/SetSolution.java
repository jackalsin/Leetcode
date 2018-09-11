package interviews.linkedin._349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

public final class SetSolution implements Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    final Set<Integer> set1 = new HashSet<>();
    for (int n : nums1) {
      set1.add(n);
    }

    final Set<Integer> res = new HashSet<>();
    for (int n : nums2) {
      if (set1.contains(n)) {
        res.add(n);
      }
    }

    final int[] ans = new int[res.size()];
    int i = 0;
    for (int n : res) {
      ans[i++] = n;
    }
    return ans;
  }
}
