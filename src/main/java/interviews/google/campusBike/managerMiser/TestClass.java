package interviews.google.campusBike.managerMiser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/19/2020
 */
public final class TestClass {

  public static final class FordFulkerson {
    private final FlowNetwork g;
    private final int[][] costs;
    private final int[] distTo;
    private final FlowEdge[] edgeTo; // parent
    private int maxMatch = 0, minCostMaxMatch = 0;

    public FordFulkerson(final FlowNetwork g, final int[][] costs, final int s, final int t) {
      this.g = g;
//      System.err.println(g.v);
      distTo = new int[g.v];
      edgeTo = new FlowEdge[g.v];
      this.costs = costs;
      while (hasAugmentPath(g, s, t)) {
        int toAdd = Integer.MAX_VALUE, cost = 0;
        for (int i = t; i != s; i = edgeTo[i].other(i)) {
          System.err.print(String.format("%d <- ", i));
          toAdd = Math.min(toAdd, edgeTo[i].residualCapacityTo(i));
          cost += cost(edgeTo[i].other(i), i);
        }
        System.err.println("toAdd = " + toAdd);
        for (int i = t; i != s; i = edgeTo[i].other(i)) {
          edgeTo[i].addResidualCapacityTo(i, toAdd);
        }
        maxMatch += toAdd;
        this.minCostMaxMatch += cost;
      }
    }

    private boolean hasAugmentPath(final FlowNetwork g, final int s, final int t) {
      Arrays.fill(distTo, Integer.MAX_VALUE);
      Arrays.fill(edgeTo, null);
      final int v = g.v;
      distTo[s] = 0;
      for (int k = 0; k < v; k++) { // as a counter
        final int[] nextDist = new int[v];
        System.arraycopy(distTo, 0, nextDist, 0, v);
        for (int i = 0; i < v; ++i) {
//        if (distTo[i] == Integer.MAX_VALUE) continue;
          final List<FlowEdge> edges = g.adjacentLists.get(i);
          for (final FlowEdge e : edges) {
            final int next = e.other(i), cost = cost(i, next), residualCapacityTo = e.residualCapacityTo(next);
            final boolean isEval = (cost == 0 || (residualCapacityTo > 0 && nextDist[next] > (long) distTo[i] + cost));
            if (cost == 0 || (residualCapacityTo > 0 && nextDist[next] > (long) distTo[i] + cost)) {
              nextDist[next] = distTo[i] + cost;
              edgeTo[next] = e;
            }
          }
          System.err.println("k " + k + ", i = " + i + ", " + Arrays.toString(nextDist));
        }
        System.arraycopy(nextDist, 0, distTo, 0, v);
      } // end of counter loop
      System.err.println("edgeTo = " + Arrays.toString(edgeTo) + "\ndistTo = " + Arrays.toString(distTo) +
          "\nhasAugmentPath = " + (distTo[t] != Integer.MAX_VALUE));
      return distTo[t] != Integer.MAX_VALUE;
    }

    private int cost(final int from, final int to) {
      final int n = (this.g.v - 2) / 2;
      if (from == this.g.v - 1 || from == this.g.v - 2 || to == this.g.v - 1 || to == this.g.v - 2) {
        return 0;
      }
      if (from > to) {
        return costs[to][from - n];
      } else {
        return costs[from][to - n];
      }
    }

    public int getMaxMatch() {
      return this.maxMatch;
    }

    public int getMinCostMaxMatch() {
      return minCostMaxMatch;
    }
  }

  public static final class FlowNetwork {
    private final int v;
    private final List<List<FlowEdge>> adjacentLists = new ArrayList<>();

    public FlowNetwork(final int v) {
      this.v = v;
      for (int i = 0; i < v; ++i) {
        adjacentLists.add(new ArrayList<>());
      }
    }

    public void addEdge(final FlowEdge e) {
      final int v = e.from(), w = e.to();
      adjacentLists.get(v).add(e);
      adjacentLists.get(w).add(e);
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      for (int i = 0; i < v; ++i) {
        sb.append("i = ").append(i).append(", ").append(adjacentLists.get(i)).append("\n");
      }
      return "FlowNetwork{" +
          "v=" + v +
          ", adjacentLists=\n" + sb +
          '}';
    }
  }

  public static final class FlowEdge {

    /**
     * v  from
     * w  to
     */
    private final int v, w, capacity;
    private int flow = 0;

    public FlowEdge(int v, int w, int capacity) {
      if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
      if (w < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
      if (!(capacity >= 0)) throw new IllegalArgumentException("Edge capacity must be non-negative");
      this.v = v;
      this.w = w;
      this.capacity = capacity;
    }

    public int from() {
      return v;
    }

    public int to() {
      return w;
    }

    public int residualCapacityTo(int v) {
      if (this.v == v) {
        return flow; // backward edge
      } else if (v == w) {
        return capacity - flow; // forward edge
      } else {
        throw new IllegalArgumentException("invalid endpoint");
      }
    }

    public void addResidualCapacityTo(final int v, final int delta) {
      if (!(delta >= 0.0)) throw new IllegalArgumentException("Delta must be nonnegative");
      if (this.v == v) { // backward edge
        flow -= delta;
      } else if (this.w == v) {
        flow += delta;
      } else {
        throw new IllegalArgumentException("invalid endpoint");
      }
      if (flow < 0 || flow > capacity) {
        throw new IllegalArgumentException(String.format("Flow should be [%d, %d], but now %d", 0, capacity, flow));
      }
    }

    public int other(final int v) {
      if (this.v == v) {
        return w;
      } else if (this.w == v) {
        return this.v;
      } else {
        throw new IllegalArgumentException("invalid endpoint");
      }
    }

    @Override
    public String toString() {
      return "FlowEdge{" +
          "v=" + v +
          ", w=" + w +
          ", capacity=" + capacity +
          ", flow=" + flow +
          '}';
    }
  }

  public static void main(String args[]) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      final int n = Integer.parseInt(br.readLine());
//      final List<List<Integer>> costMatrix = new ArrayList<>();
      final int[][] costMatrix = new int[n][n];
      String line;
      for (int row = 0; (line = br.readLine()) != null; row++) {
        final String[] items = line.split(" ");
        if (items.length != n) throw new IllegalArgumentException(
            String.format("line = %s should contains %d elements, but now %d", line, n, items.length)
        );
        for (int i = 0; i < n; ++i) {
          costMatrix[row][i] = Integer.parseInt(items[i]);
        }
      }
      // init graph
      final int s = n + n, t = s + 1;
      FlowNetwork g = new FlowNetwork(t + 1);
      for (int i = 0; i < n; ++i) {
        g.addEdge(new FlowEdge(s, i, 1));
        g.addEdge(new FlowEdge(n + i, t, 1));
      }
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          g.addEdge(new FlowEdge(i, j + n, 1));
        }
      }
//      System.err.println(g);
      FordFulkerson solution = new FordFulkerson(g, costMatrix, s, t);
      System.out.print(solution.minCostMaxMatch);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

