package _1001_1050._1007_Minimum_Domino_Rotations_For_Equal_Row;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int minDominoRotations(int[] A, int[] B) {
    if (A.length == 0) {
      return 0;
    }
    Set<Integer> prev = new HashSet<Integer>() {{
      add(A[0]);
      add(B[0]);
    }};
    // ------------- start who is the answer
    final int n = A.length;
    for (int i = 1; i < A.length; ++i) {
      final Set<Integer> cur = new HashSet<>();
      if (prev.contains(A[i])) {
        cur.add(A[i]);
      }
      if (prev.contains(B[i])) {
        cur.add(B[i]);
      }
      if (cur.isEmpty()) {
        return -1;
      }
      prev = cur;
    }
//    System.out.println(prev);
    // ------------- do the count
    final Map<Integer, int[]> counts = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      if (prev.contains(A[i])) {
        counts.computeIfAbsent(A[i], k -> new int[2])[0]++;
      }
      if (prev.contains(B[i])) {
        counts.computeIfAbsent(B[i], k -> new int[2])[1]++;
      }
    }
    counts.forEach((key, value) -> System.out.println(key + ", " + Arrays.toString(value)));
    final int[] vals = counts.entrySet().iterator().next().getValue();
    return Math.min(Math.min(vals[0], vals[1]), Math.min(n - vals[0], n - vals[1]));
  }
}
