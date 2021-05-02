package facebook.practice.Magical_Candy_Bags;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maxCandies(int[] arr, int k) {
    if (arr == null || arr.length == 0) return 0;
    final Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    for (int a : arr) {
      pq.add(a);
    }
    int res = 0;
    for (int i = 0; i < k; ++i) {
      final int toRemove = pq.remove();
      res += toRemove;
      pq.add(toRemove / 2);
    }
    return res;
  }
}
