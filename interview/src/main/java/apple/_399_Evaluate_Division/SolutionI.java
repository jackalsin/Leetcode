package apple._399_Evaluate_Division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
public final class SolutionI implements Solution {
  private final Map<String, Map<String, Double>> parentToChildToRatio = new HashMap<>();

  public double[] calcEquation(final List<List<String>> equations, final double[] values,
                               final List<List<String>> queries) {
    assert equations.size() == values.length;
    for (int i = 0; i < values.length; ++i) {
      final List<String> pair = equations.get(i);
      final String parent = pair.get(0), child = pair.get(1);
      parentToChildToRatio.computeIfAbsent(parent, k -> new HashMap<>()).put(child, values[i]);
      parentToChildToRatio.computeIfAbsent(child, k -> new HashMap<>()).put(parent, 1d / values[i]);
    }
    final int qn = queries.size();
    final double[] result = new double[qn];
    for (int i = 0; i < qn; i++) {
      final List<String> q = queries.get(i);
      final Set<String> visited = new HashSet<>() {{
        add(q.get(0));
      }};
      if (parentToChildToRatio.containsKey(q.get(0)) && parentToChildToRatio.containsKey(q.get(1))) {
        final double ratio = dfs(q.get(0), q.get(1), visited, 1d);
        result[i] = ratio;
      } else {
        result[i] = -1d;
      }
    }
    return result;
  }

  /**
   * return ratio if found; otherwise, -1d;
   */
  private double dfs(final String start, final String target,
                     final Set<String> visited, final double ratio) {
    if (start.equals(target)) {
      return ratio;
    }
    final Map<String, Double> next = parentToChildToRatio.get(start);
    if (next == null) {
      return -1d;
    }
    for (final var e : next.entrySet()) {
      final String c = e.getKey();
      final double cRate = e.getValue();
      if (!visited.add(c)) {
        continue;
      }
      final double result = dfs(c, target, visited, ratio * cRate);
      if (result >= 0) {
        visited.remove(c);
        return result;
      }
      visited.remove(c);
    }

    return -1d;
  }
}
