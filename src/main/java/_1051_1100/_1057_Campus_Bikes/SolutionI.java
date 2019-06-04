package _1051_1100._1057_Campus_Bikes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SolutionI implements Solution {

  /**
   * Time complexity O(WB * log (WB))
   *
   * @param workers
   * @param workers
   * @return Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
   */
  @Override
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    assert 1 <= workers.length && workers.length <= bikes.length && bikes.length <= 1000;
    // {distance, worker index, bike index}
    final Queue<int[]> pq = new PriorityQueue<>(
        new Comparator<int[]>() {
          @Override
          public int compare(final int[] a, final int[] b) {
            final int cmpDistance = Integer.compare(a[0], b[0]);
            if (cmpDistance == 0) {
              final int cmpWorker = Integer.compare(a[1], b[1]);
              if (cmpWorker == 0) {
                return Integer.compare(a[2], b[2]);
              }
              return cmpWorker;
            }
            return cmpDistance;
          }
        }
    );
    for (int i = 0; i < workers.length; i++) {
      for (int j = 0; j < bikes.length; j++) {
        final int[] e = new int[]{getDistance(workers[i], bikes[j]), i, j};
        pq.add(e);
      }
    }
    final int[] res = new int[workers.length];
    Arrays.fill(res, -1);
    final Set<Integer> visitedBikes = new HashSet<>();
    while (visitedBikes.size() < workers.length) {
      final int[] toRemove = pq.remove();
      final int workerIndex = toRemove[1], bikeIndex = toRemove[2];
      if (res[workerIndex] == -1 && !visitedBikes.contains(bikeIndex)) {
        visitedBikes.add(bikeIndex);
        res[workerIndex] = bikeIndex;
      }
    }
    return res;
  }

  private static int getDistance(final int[] a, final int[] b) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }

}
