package uber._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public final class NaiveSolution implements Solution {
  public List<int[]> kSmallestPairs(final int[] nums1, final int[] nums2, final int k) {
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o2[0] + o2[1], o1[0] + o1[1]);
      }
    });

    for (final int num1 : nums1) {
      for (final int num2 : nums2) {
        pq.add(new int[]{num1, num2});
        if (pq.size() > k) {
          pq.remove();
        }
      }
    }

    final List<int[]> result = new ArrayList<>();
    for (int i = 0; i < k && !pq.isEmpty(); i++) {
      result.add(pq.remove());
    }
    Collections.reverse(result);
    return result;
  }
}
