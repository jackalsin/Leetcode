package _0851_0900._857_Minimum_Cost_to_Hire_K_Workers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/10/2020
 */
public final class SolutionI implements Solution {
  /**
   * Time Complexity: O(NLogN)
   * Space Complexity: O(N)
   */
  @Override
  public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
    assert K >= 1;
    final int n = quality.length;
    final double[][] minRatioWorkers = new double[n][2];
    for (int i = 0; i < n; ++i) {
      minRatioWorkers[i][0] = (double) wage[i] / quality[i];
      minRatioWorkers[i][1] = quality[i];
    }
    Arrays.sort(minRatioWorkers, (w1, w2) -> Double.compare(w1[0], w2[0]));
    final Queue<Double> maxQuality = new PriorityQueue<>((x, y) -> Double.compare(y, x));
    double sumK = 0, result = Double.MAX_VALUE;
    for (int i = 0, len = minRatioWorkers.length; i < len; i++) {
      final double[] worker = minRatioWorkers[i];
      sumK += worker[1];
      maxQuality.add(worker[1]);
      if (i >= K) sumK -= maxQuality.remove();
      if (i >= K - 1) result = Math.min(result, sumK * worker[0]);
    }
    return result;
  }
}
