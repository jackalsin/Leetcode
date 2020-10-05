package linkedin._658_Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class PriorityQueueSolution implements Solution {
  /**
   * O (NLogK)
   *
   * @param nums
   * @param k
   * @param x
   * @return
   */
  @Override
  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    final Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        final int cmp = Long.compare(Math.abs((long) o2 - x), Math.abs((long) o1 - x));
        if (cmp == 0) {
          return Integer.compare(o2, o1);
        }
        return cmp;
      }
    });
    for (int i : nums) {
      pq.add(i);
      if (pq.size() > k) {
        pq.remove();
      }
    }
    final List<Integer> result = new ArrayList<>(pq);
    Collections.sort(result);
    return result;
  }
}
