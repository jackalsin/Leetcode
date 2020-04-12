package _1001_1050._1046_Last_Stone_Weight;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int lastStoneWeight(int[] stones) {
    if (stones == null || stones.length == 0) {
      return 0;
    }
    if (stones.length == 1) {
      return stones[0];
    }
    final Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int n : stones) {
      pq.add(n);
    }
    while (pq.size() > 1) {
      final int a = pq.remove(), b = pq.remove();
      final int c = Math.abs(b - a);
      if (c != 0) {
        pq.add(c);
      }
    }
    return pq.isEmpty() ? 0 : pq.remove();
  }
}
