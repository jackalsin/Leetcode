package _1351_1400._1387_Sort_Integers_by_The_Power_Value;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/14/2021
 */
public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> CACHE = new HashMap<>();

  static {
    CACHE.put(0, 0);
    CACHE.put(1, 0);
    CACHE.put(2, 0);
  }

  public int getKth(int lo, int hi, int k) {
    if (CACHE.size() == 3) {
      for (int i = 2; i <= 1000; i++) {
        compute(i);
      }
    }
    final Queue<int[]> q = new PriorityQueue<>((a, b) -> {
      final int cmp1 = -Integer.compare(a[1], b[1]);
      if (cmp1 != 0) return cmp1;
      return -Integer.compare(a[0], b[0]);
    });
    for (int i = lo; i <= hi; ++i) {
      q.add(new int[]{i, CACHE.get(i)});
      if (q.size() > k) q.remove();
    }
    assert q.peek() != null;
    return q.peek()[0];
  }

  private static int compute(final int n) {
    if (n < 2) {
      return 0;
    }
    if (CACHE.containsKey(n)) {
      return CACHE.get(n);
    }
    final int res = 1 + (n % 2 == 0 ? compute(n / 2) : compute(3 * n + 1));
    CACHE.put(n, res);
    return res;
  }
}
