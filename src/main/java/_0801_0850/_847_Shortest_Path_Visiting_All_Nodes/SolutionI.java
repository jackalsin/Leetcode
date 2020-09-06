package _0801_0850._847_Shortest_Path_Visiting_All_Nodes;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int shortestPathLength(int[][] graph) {
    final int N = graph.length;
    final Set<Path> visited = new HashSet<>();
    final Queue<Path> q = new ArrayDeque<>();
    for (int i = 0; i < N; ++i) {
      final Path path = new Path(i);
      q.add(path);
      visited.add(path);
    }
    while (!q.isEmpty()) {
      final Path toRemove = q.remove();
      if (toRemove.visited == ((1 << N) - 1)) return toRemove.cost;
      for (int n : graph[toRemove.cur]) {
        final int nextVisit = toRemove.visited | (1 << n);
        if (nextVisit == 0) continue;
        final Path next = new Path(nextVisit, toRemove.cost + 1, n);
        if (!visited.add(next)) continue;
        q.add(next);
      }
    }
    throw new IllegalStateException("No way to reach here");
  }

  private static final class Path {
    private int visited = 0, cost = 0, cur = 0;

    private Path(int cur) {
      this.cur = cur;
      visited |= (1 << cur);
    }

    private Path(final int visited, final int cost, final int cur) {
      this.visited = visited;
      this.cost = cost;
      this.cur = cur;
    }

    private Path(final Path path) {
      this(path.visited, path.cost, path.cur);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Path)) return false;
      Path path = (Path) o;
      return visited == path.visited &&
          cur == path.cur;
    }

    @Override
    public int hashCode() {
      return Objects.hash(visited, cur);
    }
  }
}
