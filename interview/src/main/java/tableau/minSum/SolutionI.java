package tableau.minSum;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final Queue<Integer> pq = new PriorityQueue<>();
    Arrays.stream(nums).forEach(pq::add);
    while (pq.size() != 1) {
      final int a = pq.remove(), b = pq.remove();
      pq.add(a + b);
    }
    return pq.peek();
  }
}
