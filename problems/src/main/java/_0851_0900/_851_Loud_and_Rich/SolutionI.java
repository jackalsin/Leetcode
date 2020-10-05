package _0851_0900._851_Loud_and_Rich;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] loudAndRich(int[][] richer, int[] quiet) {
    final int n = quiet.length;
    final int[] leastQuietValue = new int[n], indegrees = new int[n], result = new int[n];
    final Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      parentToChildren.put(i, new ArrayList<>());
      leastQuietValue[i] = quiet[i];
      result[i] = i;
    }

    for (final int[] pair : richer) {
      final int p = pair[0], c = pair[1];
      parentToChildren.computeIfAbsent(p, k -> new ArrayList<>()).add(c);
      indegrees[c]++;
    }
    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
        indegrees[i]--; // mark as visited
      }
    }

    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      final List<Integer> children = parentToChildren.get(toRemove);
      for (final int c : children) {
        if (leastQuietValue[c] > leastQuietValue[toRemove]) {
          leastQuietValue[c] = leastQuietValue[toRemove];
          result[c] = result[toRemove];
        }
        if (--indegrees[c] == 0) {
          q.add(c);
          --indegrees[c]; // mark as visited
        }
      }
    }
    return result;
  }
}
