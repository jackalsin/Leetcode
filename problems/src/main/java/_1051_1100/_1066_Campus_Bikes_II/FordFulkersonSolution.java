package _1051_1100._1066_Campus_Bikes_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class FordFulkersonSolution implements Solution {
  private int[] distTo;
  private FlowEdge[] edgeTo; // parent

  public int assignBikes(int[][] workers, int[][] bikes) {
    final int workerLen = workers.length, bikesLen = bikes.length;
    final FlowNetwork g = new FlowNetwork(workerLen + bikesLen + 2);
    distTo = new int[g.v];
    edgeTo = new FlowEdge[g.v];
    // create graph
    final int s = workerLen + bikesLen, t = s + 1;
    for (int i = 0; i < workers.length; ++i) {
      g.addEdge(s, i, 0); // start
      for (int j = 0; j < bikes.length; ++j) {
        if (i == 0) g.addEdge(j + workerLen, t, 0); // converge
        g.addEdge(i, j + workerLen, distance(workers[i], bikes[j]));
      }
    }

    // solve
    int minCost = 0;
    while (hasAugmentPath(g, s, t)) {
      int toAdd = Integer.MAX_VALUE, cost = 0;
      for (int v = t; v != s; v = edgeTo[v].other(v)) {
        final FlowEdge e = edgeTo[v];
        toAdd = Math.min(toAdd, e.residualCapacityTo(v));
      }
      for (int v = t; v != s; v = edgeTo[v].other(v)) {
//        System.out.print(String.format("%d <- ", v));
        final FlowEdge e = edgeTo[v];
        e.addResidualCapacityTo(v, toAdd);
        if (v == e.to) {
          cost += e.cost;
        } else {
          cost -= e.cost;
        }
      }
//      System.out.println("toAdd = " + toAdd);
      minCost += cost;
    }
    return minCost;
  }

  private boolean hasAugmentPath(final FlowNetwork g, final int s, final int t) {
    Arrays.fill(edgeTo, null);
    Arrays.fill(distTo, Integer.MAX_VALUE);
    distTo[s] = 0;
    for (int k = 0; k < g.v; k++) {
      final int[] nextDistTo = new int[g.v];
      System.arraycopy(distTo, 0, nextDistTo, 0, g.v);
      for (final FlowEdge e : g.edges) {
        final int from = e.from, to = e.to, cost = e.cost;
        if (e.residualCapacityTo(to) > 0 && nextDistTo[to] > (long) distTo[from] + cost) {
          nextDistTo[to] = distTo[from] + cost;
          edgeTo[to] = e;
        } else if (e.residualCapacityTo(from) > 0 && nextDistTo[from] > (long) distTo[to] - cost) {
          nextDistTo[from] = distTo[to] - cost;
          edgeTo[from] = e;
        }
      }
      System.arraycopy(nextDistTo, 0, distTo, 0, g.v);
    }
//    System.out.println("edgeTo = " + Arrays.toString(edgeTo) + "\ndistTo = " + Arrays.toString(distTo) +
//        "\nhasAugmentPath = " + (distTo[t] != Integer.MAX_VALUE));
    return distTo[g.v - 1] != Integer.MAX_VALUE;
  }

  private static int distance(final int[] worker, final int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }

  // class
  private static final class FlowNetwork {
    private final int v;
    private final List<List<FlowEdge>> adjacentLists = new ArrayList<>();
    private final Set<FlowEdge> edges = new HashSet<>();

    private FlowNetwork(final int v) {
      this.v = v;
      for (int i = 0; i < v; ++i) {
        adjacentLists.add(new ArrayList<>());
      }
    }

    private void addEdge(final int from, final int to, final int cost) {
      assert 0 <= from && from < v && 0 <= to && to < v;
      final FlowEdge e = new FlowEdge(from, to, cost);
      adjacentLists.get(from).add(e);
      adjacentLists.get(to).add(e);
      edges.add(e);
    }
  }

  private static final class FlowEdge {
    private final int from, to, capacity, cost;
    private int flow = 0;

    private FlowEdge(int from, int to, int cost) {
      this(from, to, cost, 1);
    }

    private void addResidualCapacityTo(final int v, final int toAdd) {
      if (v == to) {
        flow += toAdd;
      } else if (v == from) {
        flow -= toAdd;
      } else {
        throw new IllegalArgumentException();
      }
    }

    private int other(final int v) {
      if (v == from) return to;
      if (v == to) return from;
      throw new IllegalArgumentException("v = " + v + " is not in the edge");
    }

    private FlowEdge(int from, int to, int cost, int capacity) {
      this.from = from;
      this.to = to;
      this.cost = cost;
      this.capacity = capacity;
    }

    private int residualCapacityTo(final int v) {
      if (to == v) { // forward edge
        return capacity - flow;
      } else {
        return flow;
      }
    }

    @Override
    public String toString() {
      return "FlowEdge{" +
          "from=" + from +
          ", to=" + to +
          ", capacity=" + capacity +
          ", cost=" + cost +
          ", flow=" + flow +
          '}';
    }
  }
}
