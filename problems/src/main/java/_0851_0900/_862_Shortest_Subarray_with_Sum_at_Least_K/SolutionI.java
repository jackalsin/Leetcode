package _0851_0900._862_Shortest_Subarray_with_Sum_at_Least_K;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int shortestSubarray(int[] A, int K) {
    /*
     *本质上，这题是求个presum，找到j使得preSum[j] - preSum[i]最小
     */
    final int n = A.length;
    final int[] sums = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      sums[i + 1] = sums[i] + A[i];
    }
    /*
     * 单调栈，最大的index使得deque[i] > deque[i - 1]
     */
    final Deque<Integer> deque = new ArrayDeque<>();
    long res = Long.MAX_VALUE;
    for (int i = 0; i < n + 1; i++) {
      // compare 每个可能的value
      while (deque.size() > 0 && sums[i] - sums[deque.peekFirst()] >= K) {
        res = Math.min(res, i - deque.removeFirst());
      }
      // 确保单调增
      while (deque.size() > 0 && sums[deque.peekLast()] >= sums[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }
    return res == Long.MAX_VALUE ? -1 : (int) res;
  }
}
