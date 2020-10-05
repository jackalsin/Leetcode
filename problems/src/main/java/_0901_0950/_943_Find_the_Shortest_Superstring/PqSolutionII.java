package _0901_0950._943_Find_the_Shortest_Superstring;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/9/2020
 */
public final class PqSolutionII implements Solution {
  @Override
  public String shortestSuperstring(String[] A) {
    final int[][] graph = getGraph(A);
    // TwoDimensionArray.println(graph);
    final Queue<State> pq = new PriorityQueue<>(new Comparator<State>() {
      @Override
      public int compare(State o1, State o2) {
        return Integer.compare(o1.sb.length(), o2.sb.length());
      }
    });
    for (int i = 0; i < A.length; i++) {
      pq.add(new State(A[i], i));
    }
    while (!pq.isEmpty()) {
      final State toRemove = pq.remove();
      if (toRemove.visited.size() == A.length) {
        return toRemove.sb.toString();
      }
      for (int i = 0; i < A.length; ++i) {
        if (toRemove.visited.contains(i)) {
          continue;
        }
        final State next = new State(toRemove);
        next.sb.append(A[i], A[i].length() - graph[toRemove.last][i], A[i].length());
        next.visited.add(i);
        next.last = i;
//        System.out.println(toRemove + " ---> " + next);
        pq.add(next);
      }
    }
    // should not reach here
    throw new IllegalStateException();
  }

  private int[][] getGraph(String[] strs) {
    final int N = strs.length;
    final int[][] res = new int[N][N];
    for (int i = 0; i < strs.length; ++i) {
      for (int j = 0; j < strs.length; ++j) {
        res[i][j] = distance(strs[i], strs[j]);
      }
    }
    return res;
  }

  private int distance(final String str1, final String str2) {
    final int len1 = str1.length(), len2 = str2.length();
    for (int overlap = str2.length(); overlap >= 0; overlap--) {
      if (str1.endsWith(str2.substring(0, overlap))) {
        return len2 - overlap;
      }
    }
    return str2.length();
  }

  private static final class State {
    private final StringBuilder sb = new StringBuilder();
    private final Set<Integer> visited = new HashSet<>();
    private int last;

    public State(final String word, final int i) {
      sb.append(word);
      visited.add(i);
      last = i;
    }

    public State(final State state) {
      sb.append(state.sb);
      visited.addAll(state.visited);
      last = state.last;
    }

    @Override
    public String toString() {
      return "State{" +
          "sb=" + sb +
          ", visited=" + visited +
          ", last=" + last +
          '}';
    }
  }
}
