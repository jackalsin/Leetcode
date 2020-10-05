package _0851_0900._870_Advantage_Shuffle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  /**
   * Time Complexity: O(N * LogN)
   * <a link="https://leetcode.com/problems/advantage-shuffle/discuss/149822/JAVA-Greedy-6-lines-with-Explanation"></a>
   */
  @Override
  public int[] advantageCount(int[] A, int[] B) {
    Arrays.sort(A);
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
    for (int i = 0; i < B.length; ++i) {
      pq.add(new int[]{B[i], i});
    }
    final int[] result = new int[A.length];
    int left = 0, right = A.length - 1;
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int val = toRemove[0], i = toRemove[1];
      result[i] = A[right] > val ? A[right--] : A[left++];
    }
    return result;
  }
}
