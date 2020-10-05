package _1351_1400._1383_Maximum_Performance_of_a_Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public class Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    final List<int[]> eList = new ArrayList<>();
    for (int i = 0; i < efficiency.length; ++i) {
      eList.add(new int[]{efficiency[i], i});
    }
    Collections.sort(eList, (x, y) -> Integer.compare(y[0], x[0]));
    long res = 0, sumOfSpeed = 0;
    final Queue<Integer> pq = new PriorityQueue<>();
    for (final int[] e : eList) {
      final int ef = e[0], i = e[1];
      pq.add(speed[i]);
      sumOfSpeed += speed[i];
      if (pq.size() > k) {
        sumOfSpeed -= pq.remove();
      }
      res = Math.max(res, sumOfSpeed * ef);
    }
    return (int) (res % MOD);
  }
}
