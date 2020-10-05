package linkedin._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/4/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    final LinkedList<List<Integer>> result = new LinkedList<>();
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return result;
    }
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        final long sum1 = (long) nums1[o1[0]] + nums2[o1[1]],
            sum2 = (long) nums1[o2[0]] + nums2[o2[1]];
        return Long.compare(sum1, sum2);
      }
    });
    final int m = nums1.length, n = nums2.length;
    for (int i = 0; i < m; ++i) {
      pq.add(new int[]{i, 0});
    }
    while (result.size() < k && !pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final List<Integer> cur = new ArrayList<>();
      cur.add(nums1[toRemove[0]]);
      cur.add(nums2[toRemove[1]]);
      result.add(cur);
      if (toRemove[1] + 1 < n) {
        pq.add(new int[]{toRemove[0], toRemove[1] + 1});
      }
    }
    return result;
  }
}
