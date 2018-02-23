package interviews.uber._373_Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLogKSolution implements Solution {
  /**
   * Time complexity: O(KLogK), where K is Math.min(k, nums1.length, nums2.length)
   * Space complexity: O(K)
   * Explanation:
   * https://jackalsin.gitbooks.io/algorithm/content/373.html
   * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
   *
   * @param nums1
   * @param nums2
   * @param k
   * @return
   */
  @Override
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, final int k) {
    /* Small to big */
    final Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0] + o1[1], o2[0] + o2[1]);
      }
    });

    final List<int[]> result = new ArrayList<>();

    if (nums2.length == 0) {
      return result;
    }

    for (int i = 0; i < k && i < nums1.length; i++) {
      /* Add an array nums1[i], nums2[j], j */
      queue.add(new int[]{nums1[i], nums2[0], 0});
    }

    for (int i = 0; i < k && !queue.isEmpty(); i++) {
      final int[] cur = queue.remove();
      result.add(new int[]{cur[0], cur[1]});

      final int curNums2Index = cur[2];
      if (curNums2Index != nums2.length - 1) {
        queue.add(new int[]{cur[0], nums2[curNums2Index + 1], curNums2Index + 1});
      }
    }
    return result;
  }
}
