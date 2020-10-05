package linkedin._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/21/2019
 */
public final class SolutionII implements Solution {

  /**
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    /* value pair */
    final List<List<Integer>> result = new ArrayList<>();
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return result;
    }
    /* index pair */
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Long.compare((long) nums1[o1[0]] + (long) nums2[o1[1]], (long) nums1[o2[0]] + (long) nums2[o2[1]]);
      }
    });

    // init
    for (int i = 0; i < nums1.length && i < k; i++) {
      pq.add(new int[]{i, 0});
    }
    for (int i = 0; i < k; i++) {
      if (pq.isEmpty()) break;
      final int[] index = pq.remove();
      result.add(Arrays.asList(nums1[index[0]], nums2[index[1]]));
      if (index[1] + 1 < nums2.length) {
        pq.add(new int[]{index[0], index[1] + 1});
      }
    }
    return result;
  }
}
