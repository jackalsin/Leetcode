package _0701_0750._703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/15/2020
 */
public final class KthLargestI implements KthLargest {
  private final Queue<Integer> pq = new PriorityQueue<>(Integer::compare);
  private final int k;

  public KthLargestI(int k, int[] nums) {
    this.k = k;
    for (final int n : nums) {
      pq.add(n);
      if (pq.size() > k) {
        pq.remove();
      }
    }
  }

  public int add(int val) {
    pq.add(val);
    if (pq.size() > k) pq.remove();
    return pq.peek();
  }
}
