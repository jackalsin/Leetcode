package byteDance._1057_Campus_Bikes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    // {work index, bike index, distance}
    final List<int[]>[] buckets = new ArrayList[2001];
    for (int wi = 0; wi < workers.length; ++wi) {
      for (int bi = 0; bi < bikes.length; ++bi) {
        final int distance = distance(workers[wi], bikes[bi]);
        if (buckets[distance] == null) {
          buckets[distance] = new ArrayList<>();
        }
        buckets[distance].add(new int[]{wi, bi, distance});
      }
    }
    final int n = workers.length;
    final Set<Integer> usedBikes = new HashSet<>(bikes.length);
    final int[] result = new int[n];
    Arrays.fill(result, -1);
    for (int bucketIndex = 0; bucketIndex < buckets.length && usedBikes.size() < workers.length; bucketIndex++) {
      if (buckets[bucketIndex] == null) continue;
      final List<int[]> bucket = buckets[bucketIndex];
      for (final int[] toRemove : bucket) {
        final int wi = toRemove[0], bi = toRemove[1], d = toRemove[2];
        if (result[wi] != -1) continue;
        if (usedBikes.contains(bi)) continue;
        usedBikes.add(bi);
        result[wi] = bi;
      }
    }
    return result;
  }

  private static int distance(final int[] a, final int[] b) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }
}
