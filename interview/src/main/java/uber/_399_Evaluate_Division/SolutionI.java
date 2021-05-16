package uber._399_Evaluate_Division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  private final Map<String, Map<String, Double>> map = new HashMap<>();


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

  @Override
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    for (int i = 0; i < equations.size(); i++) {
      final List<String> pair = equations.get(i);
      final double value = values[i];
      insertToMap(pair.get(0), pair.get(1), value);
      insertToMap(pair.get(1), pair.get(0), 1d / value);
    }
    final double[] result = new double[queries.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = dfs(new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
    }
    return result;
  }
}
