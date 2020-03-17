package _1051_1100._1057_Campus_Bikes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/16/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    // {distance, worker index, bike index }
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] x, int[] y) {
        final int distanceCmp = Integer.compare(x[0], y[0]);
        if (distanceCmp != 0) {
          return distanceCmp;
        }
        final int workerCmp = Integer.compare(x[1], y[1]);
        if (workerCmp != 0) {
          return workerCmp;
        }
        return Integer.compare(x[2], y[2]);
      }
    });
    for (int w = 0; w < workers.length; w++) {
      for (int b = 0; b < bikes.length; b++) {
        final int distance = getDistance(workers[w], bikes[b]);
        pq.add(new int[]{distance, w, b});
      }
    }
    final int[] result = new int[workers.length];
    final boolean[] usedBikes = new boolean[bikes.length];
    Arrays.fill(result, -1);
    int count = 0;
    while (count < workers.length) {
      assert !pq.isEmpty();
      final int[] remove = pq.remove();
      final int worker = remove[1], bike = remove[2];
//      System.out.println("Remove = " + Arrays.toString(remove) + "\nresult = " + Arrays.toString(result) + ",
//      usedBikes = " + Arrays.toString(usedBikes));
      if (!usedBikes[bike] && result[worker] == -1) {
        count++;
        usedBikes[bike] = true;
        result[worker] = bike;
      }
    }
    return result;
  }

  private int getDistance(final int[] worker, final int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }
}
