package google._399_Evaluate_Division;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
public final class SolutionII implements Solution {
  private final Map<String, Map<String, Double>> ratioMap = new HashMap<>();

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    for (int i = 0; i < equations.size(); ++i) {
      final List<String> e = equations.get(i);
      ratioMap.computeIfAbsent(e.get(0), k -> new HashMap<>()).put(e.get(1), values[i]);
      ratioMap.computeIfAbsent(e.get(1), k -> new HashMap<>()).put(e.get(0), 1d / values[i]);
    }
    final double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      final List<String> q = queries.get(i);
      result[i] = eval(q.get(0), q.get(1));
    }
    return result;
  }

  private double eval(final String from, final String to) {
    if (!ratioMap.containsKey(from) || !ratioMap.containsKey(to)) {
      return -1d;
    }
    if (from.equals(to)) {
      return 1;
    }
    final Queue<Pair> q = new ArrayDeque<>() {{
      add(new Pair(from, 1d));
    }};
    final Set<String> visited = new HashSet<>() {{
      add(from);
    }};
    while (!q.isEmpty()) {
      final Pair p = q.remove();
      final String str = p.str;
      final double srcRatio = p.val;
      final Map<String, Double> children = ratioMap.getOrDefault(str, new HashMap<>());
      for (final Map.Entry<String, Double> c : children.entrySet()) {
        final String nextWord = c.getKey();
        final double nextRatio = srcRatio * c.getValue();
        if (nextWord.equals(to)) {
          return nextRatio;
        }
        if (visited.add(nextWord)) {
          q.add(new Pair(nextWord, nextRatio));
        }
      }
    }
    return -1d;
  }

  private static final class Pair {
    private final String str;
    private final double val;

    private Pair(String str, double val) {
      this.str = str;
      this.val = val;
    }
  }
}
