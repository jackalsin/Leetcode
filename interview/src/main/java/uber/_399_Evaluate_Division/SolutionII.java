package uber._399_Evaluate_Division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionII implements Solution {

  @Override
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    final Map<String, Map<String, Double>> srcToTgtToRatio = getMap(equations, values);
    final int len = queries.size();
    final double[] result = new double[len];
    for (int i = 0; i < len; ++i) {
      result[i] = dfs(srcToTgtToRatio, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
    }
    return result;
  }

  private double dfs(final Map<String, Map<String, Double>> srcToTgtToRatio, final String start, final String target,
                     final Set<String> visited) {
    if (!srcToTgtToRatio.containsKey(start) || !srcToTgtToRatio.containsKey(target)) {
      return -1;
    }
    if (start.equals(target)) {
      return 1;
    }
    if (!visited.add(start)) return -1d;
    final Map<String, Double> nextMap = srcToTgtToRatio.get(start);
    for (final var e : nextMap.entrySet()) {
      final String next = e.getKey();
      final double val = e.getValue(),
          res = dfs(srcToTgtToRatio, next, target, visited);
      if (res != -1) {
        return val * res;
      }
    }
    return -1;
  }

  private Map<String, Map<String, Double>> getMap(List<List<String>> equations, double[] values) {
    final Map<String, Map<String, Double>> result = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      final List<String> equation = equations.get(i);
      final String s = equation.get(0), t = equation.get(1);
      result.computeIfAbsent(s, k -> new HashMap<>()).put(t, values[i]);
      result.computeIfAbsent(t, k -> new HashMap<>()).put(s, 1d / values[i]);
    }
    return result;
  }

}
