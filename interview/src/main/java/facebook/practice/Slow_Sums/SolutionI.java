package facebook.practice.Slow_Sums;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class SolutionI implements Solution {
  public int getTotalTime(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    final Queue<Integer> pq = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));
    for (final int a : arr) {
      pq.add(a);
    }
    int sum = 0;
    while (pq.size() != 1) {
      final int a = pq.remove(), b = pq.remove(), c = a + b;
      sum += c;
      pq.add(c);
    }
    return sum;
  }
}
