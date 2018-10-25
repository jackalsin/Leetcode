package interviews.linkedin._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.*;

public final class SolutionI implements Solution {
  @Override
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    final List<int[]> result = new ArrayList<>();
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
      return result;
    }

    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
      }
    });
    for (int n : nums1) {
      pq.add(new int[]{n, nums2[0], 0});
    }

    for (int i = 0; i < k; i++) {
      if (pq.isEmpty()) break;
      final int[] toRemove = pq.remove();
      result.add(new int[]{toRemove[0], toRemove[1]});
      if (toRemove[2] != nums2.length - 1) {
        pq.add(new int[]{toRemove[0], nums2[toRemove[2] + 1], toRemove[2] + 1});
      }
    }

    return result;
  }
}
