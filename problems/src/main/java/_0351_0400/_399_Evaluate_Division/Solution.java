package _0351_0400._399_Evaluate_Division;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class Solution {
  private final Map<String, List<String>> valuePairs = new HashMap<>();
  private final Map<String, List<Double>> weightPairs = new HashMap<>();

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    initialization(equations, values);
    final double[] result = new double[queries.length];
    for (int i = 0; i < queries.length; i++) {
      final String[] query = queries[i];
      Set<String> visited = new HashSet<>();
      double curRes = -1d;
      if (valuePairs.containsKey(query[0]) && valuePairs.containsKey(query[1])) {
        curRes = bfs(query[0], query[1], 1, equations.length, visited);
      }
      result[i] = curRes;
    }
    return result;
  }

  private double bfs(final String start,final String target, final double lastResult,
                     final int maxSize, final Set<String> visited) {
    if (start.equals(target)) {
      return lastResult;
    } else if (visited.size() == maxSize) {
      return -1d;
    } else {
      visited.add(start);
      final List<String> nextRound = valuePairs.get(start);
      final List<Double> nextRoundWeight = weightPairs.get(start);
      if (nextRound == null) return -1d;
      for (int i = 0; i < nextRound.size(); i++) {
        final String nextRoundChild = nextRound.get(i);
        final double times = nextRoundWeight.get(i);
        if (!visited.contains(nextRoundChild)) {
          double nextRoundRes = bfs(nextRoundChild, target, lastResult * times, maxSize, visited);
          if (nextRoundRes != -1d) {
            return nextRoundRes;
          }
        }
      }
      return -1d;
    }
  }

  private void initialization(final String[][] equations, final double[] values) {
    for (int i = 0; i < equations.length; i++) {
      final String[] equation = equations[i];
      insertToMap(equation[0], equation[1], values[i]);
      insertToMap(equation[1], equation[0], 1d / values[i]);
    }
  }

  private void insertToMap(final String from, final String to, final double value) {
    valuePairs.putIfAbsent(from, new ArrayList<>());
    valuePairs.get(from).add(to);
    weightPairs.putIfAbsent(from, new ArrayList<>());
    weightPairs.get(from).add(value);
  }

}
