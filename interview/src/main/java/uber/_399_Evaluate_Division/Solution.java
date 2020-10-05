package uber._399_Evaluate_Division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
  private final Map<String, Map<String, Double>> map = new HashMap<>();

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    for (int i = 0; i < equations.length; i++) {
      final String[] pair = equations[i];
      final double value = values[i];
      insertToMap(pair[0], pair[1], value);
      insertToMap(pair[1], pair[0], 1d / value);
    }
    final double[] result = new double[queries.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = dfs(new HashSet<>(), queries[i][0], queries[i][1]);
    }
    return result;
  }

  private double dfs(final HashSet<String> visited,
                     final String start, final String end) {
    if (!map.containsKey(start)) {
      return -1d;
    }
    if (start.equals(end)) {
      return 1d;
    }
    final Map<String, Double> childrenToTimes = map.get(start);
    assert childrenToTimes != null;
    for (Map.Entry<String, Double> nextEntry : childrenToTimes.entrySet()) {
      final String next = nextEntry.getKey();
      final double nextTimes = nextEntry.getValue();
      if (visited.contains(next)) continue;
      visited.add(next);
      final double nextRes = dfs(visited, next, end);
      if (nextRes == -1d) continue;
      return nextTimes * nextRes;
    }
    return -1d;
  }

  private void insertToMap(final String i, final String j, final double times) {
    if (!map.containsKey(i)) {
      map.put(i, new HashMap<>());
    }
    map.get(i).put(j, times);
  }
}
