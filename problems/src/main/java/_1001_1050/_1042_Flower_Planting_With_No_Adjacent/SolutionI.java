package _1001_1050._1042_Flower_Planting_With_No_Adjacent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] gardenNoAdj(int N, int[][] paths) {
    final Map<Integer, Set<Integer>> adjs = new HashMap<>();
    for (final int[] p : paths) {
      adjs.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
      adjs.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
    }

    final Set<Integer> candidates = new HashSet<>() ;
    final int[] result = new int[N];
    for (int i = 1; i <= N; ++i) {
      final Set<Integer> neighbors = adjs.getOrDefault(i, new HashSet<>()),
          curCandidates = new HashSet<>(candidates);
      for (final int n : neighbors) {
        curCandidates.remove(result[n - 1]);
      }
      if (curCandidates.isEmpty()) {
        result[i - 1] = candidates.size() + 1;
        candidates.add(candidates.size() + 1);
      } else {
        result[i - 1] = curCandidates.iterator().next();
      }
    }
    return result;
  }
}
