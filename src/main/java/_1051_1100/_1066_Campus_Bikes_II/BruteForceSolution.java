package _1051_1100._1066_Campus_Bikes_II;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class BruteForceSolution implements Solution {
  @Override
  public int assignBikes(int[][] workers, int[][] bikes) {
    final Queue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.compare(o1.cost, o2.cost);
      }
    });
    final Set<Pair> seen = new HashSet<>();
    final Pair start = new Pair(0, 0, 0);
    pq.add(start);
    seen.add(start);
    while (!pq.isEmpty()) {
      final Pair toRemove = pq.remove();
      if (toRemove.toMatchWorkerId == workers.length) return toRemove.cost;
      for (int bi = 0; bi < bikes.length; ++bi) {
        final int bit = 1 << bi;
        if ((bit & toRemove.visited) == 0) {
//          System.out.println("worker id, " + toRemove.toMatchWorkerId + ", bike id = " + bi);
          final int nextCost = toRemove.cost + distance(workers[toRemove.toMatchWorkerId], bikes[bi]),
              nextVisit = bit | toRemove.visited;
          final Pair toAdd = new Pair(nextCost, nextVisit, toRemove.toMatchWorkerId + 1);
          if (seen.add(toAdd)) {
            pq.add(toAdd);
          }
        }
      }
    }
    throw new IllegalStateException("No perfect match is found");
  }

  private static final class Pair {
    private final int cost, visited, toMatchWorkerId;

    private Pair(int cost, int visited, int toMatchWorkerId) {
      this.cost = cost;
      this.visited = visited;
      this.toMatchWorkerId = toMatchWorkerId;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Pair)) return false;
      Pair pair = (Pair) o;
      return cost == pair.cost &&
          visited == pair.visited &&
          toMatchWorkerId == pair.toMatchWorkerId;
    }

    @Override
    public int hashCode() {
      return Objects.hash(cost, visited, toMatchWorkerId);
    }

    @Override
    public String toString() {
      return "Pair{" +
          "cost=" + cost +
          ", visited=" + visited +
          ", toMatchWorkerId=" + toMatchWorkerId +
          '}';
    }
  }

  private static int distance(final int[] worker, final int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }
}
