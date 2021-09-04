package airbnb._1387_Sort_Integers_by_The_Power_Value;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/3/2021
 */
public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> CACHE = new HashMap<>();

  static {
    CACHE.put(0, 0);
    CACHE.put(1, 0);
    CACHE.put(2, 1);
  }

  public int getKth(int lo, int hi, int k) {
    if (CACHE.size() == 3) {
      for (int i = 3; i <= 1000; ++i) {
        compute(i);
      }
    }
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
      final int powerCmp = -Integer.compare(a[1], b[1]);
      if (powerCmp != 0) return powerCmp;
      return -Integer.compare(a[0], b[0]);
    });
    for (int i = lo; i <= hi; ++i) {
      pq.add(new int[]{i, compute(i)});
      if (pq.size() > k) pq.remove();
    }
    return pq.peek()[0];
  }

  private static int compute(final int n) {
    if (CACHE.containsKey(n)) return CACHE.get(n);
    final int res = 1 + (n % 2 == 0 ? compute(n / 2) : compute(3 * n + 1));
    CACHE.put(n, res);
    return res;
  }
}
