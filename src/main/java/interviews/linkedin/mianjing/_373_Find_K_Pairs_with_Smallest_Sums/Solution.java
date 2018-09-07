package interviews.linkedin.mianjing._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public class Solution {
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    // pq of int[], 0 -> nums1 elem, 1 -> nums2 elem, 2 -> nums2的index
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new ArrayList<>();
    }
    final PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(final int[] nums1, final int[] nums2) {
        return Integer.compare(nums1[0] + nums1[1], nums2[0] + nums2[1]);
      }
    });
    for (int i = 0; i < nums1.length; ++i) {
      pq.add(new int[]{nums1[i], nums2[0], 0});
    }
    final List<int[]> result = new ArrayList<>();
    while (k-- > 0 && !pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      result.add(new int[]{toRemove[0], toRemove[1]});
      final int i = toRemove[2];
      if (i != nums2.length - 1) {
        pq.add(new int[]{toRemove[0], nums2[i + 1], i + 1});
      }
    }

    return result;
  }
}
