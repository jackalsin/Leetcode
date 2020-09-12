package _0851_0900._857_Minimum_Cost_to_Hire_K_Workers;

import java.util.Comparator;
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
    final Queue<Integer> minRatioToMinQuality =
        new PriorityQueue<>(Comparator.comparingDouble(i -> (double) wage[i] / quality[i]));
    for (int i = 0; i < quality.length; ++i) {
      minRatioToMinQuality.add(i);
    }
    double sumK = 0, result = Double.MAX_VALUE;
    final Queue<Integer> maxQuality = new PriorityQueue<>((i, j) -> Integer.compare(quality[j], quality[i]));
    final Queue<Integer> maxRatio =
        new PriorityQueue<>((i, j) -> -Double.compare((double) wage[i] / quality[i], (double) wage[j] / quality[j]));
    for (int i = 0; i < quality.length; ++i) {
      final int toAdd = minRatioToMinQuality.remove();
      maxRatio.add(toAdd);
      sumK += quality[toAdd];
      maxQuality.add(toAdd);
      if (i >= K - 1) {
        if (i > K - 1) {
          final int toRemove = maxQuality.remove();
          sumK -= quality[toRemove];
          maxRatio.remove(toRemove);
        }
        assert !maxRatio.isEmpty();
        final double ratio = ratio(wage[maxRatio.peek()], quality[maxRatio.peek()]);
        result = Math.min(result, sumK * ratio);
      }
    }
    return result;
  }

  private static double ratio(final double wage, final double quality) {
    return wage / quality;
  }
}
