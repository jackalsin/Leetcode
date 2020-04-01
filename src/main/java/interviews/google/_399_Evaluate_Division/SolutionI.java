package interviews.google._399_Evaluate_Division;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/23/2018.
 */
public final class SolutionI implements Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    /* this to other to weight */
    final Map<String, Set<Node>> edges = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      final List<String> equation = equations.get(i);
      edges.putIfAbsent(equation.get(0), new HashSet<>());
      edges.putIfAbsent(equation.get(1), new HashSet<>());
      edges.get(equation.get(0)).add(new Node(equation.get(1), values[i]));
      edges.get(equation.get(1)).add(new Node(equation.get(0), 1d / values[i]));
    }
    final double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      final List<String> query = queries.get(i);
      if (!edges.containsKey(query.get(0)) || !edges.containsKey(query.get(1))) {
        result[i] = -1;
      } else {
        result[i] = search(edges, query.get(0), query.get(1));
      }
    }
    return result;
  }

  private double search(final Map<String, Set<Node>> edges, final String start, final String end) {
    final Set<String> visited = new HashSet<>();
    final Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(start, 1d));
    while (!queue.isEmpty()) {
      final Node removed = queue.remove();
      if (!visited.contains(removed.v)) {
        visited.add(removed.v);
        if (removed.v.equals(end)) {
          return removed.w;
        } else {
          final Set<Node> nextEdges = edges.get(removed.v);
          for (final Node nextEdge : nextEdges) {
            if (!visited.contains(nextEdge.v)) {
              queue.add(new Node(nextEdge.v, removed.w * nextEdge.w));
            }
          }
        }
      }
    }
    return -1;
  }

  private static final class Node {
    private final String v;
    private final double w;

    public Node(String v, double w) {
      this.v = v;
      this.w = w;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return Double.compare(node.w, w) == 0 &&
          Objects.equals(v, node.v);
    }

    @Override
    public int hashCode() {

      return Objects.hash(v, w);
    }
  }
}
