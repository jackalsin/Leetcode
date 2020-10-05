package uber._1057_Campus_Bikes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/8/2020
 */
public final class PqSolution implements Solution {
  @Override
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        final int distanceCmp = Integer.compare(o1[0], o2[0]);
        if (distanceCmp != 0) {
          return distanceCmp;
        }
        final int workerCmp = Integer.compare(o1[2], o2[2]);
        if (workerCmp != 0) {
          return workerCmp;
        }
        return Integer.compare(o1[1], o2[1]);
      }
    });
    for (int workerIndex = 0; workerIndex < workers.length; workerIndex++) {
      final int[] worker = workers[workerIndex];
      for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
        final int[] bike = bikes[bikeIndex];
        pq.add(new int[]{distance(worker, bike), bikeIndex, workerIndex});
      }
    }
    final int[] result = new int[workers.length];
    Arrays.fill(result, -1);
    final Set<Integer> visitedBikes = new HashSet<>();
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int bikeIndex = toRemove[1], workerIndex = toRemove[2];
      if (result[workerIndex] != -1) continue;
      if (visitedBikes.add(bikeIndex)) {
        result[workerIndex] = bikeIndex;
      }
    }
    return result;
  }

  private static int distance(final int[] p1, final int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }

}
