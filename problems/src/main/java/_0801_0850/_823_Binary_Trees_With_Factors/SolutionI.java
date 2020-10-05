package _0801_0850._823_Binary_Trees_With_Factors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int numFactoredBinaryTrees(int[] A) {
    final int n = A.length;
    Arrays.sort(A);
    int res = 0;
    final Map<Integer, Integer> valToCount = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      final int val = A[i];
      int count = 1; // self
      for (int v : A) {
        if (v > val / v) break;
        if (val % v != 0) continue;
        final int other = val / v;
        if (valToCount.containsKey(other) && valToCount.containsKey(v)) {
          count = safeAdd(count, (v == other ? 1L : 2L) * valToCount.get(other) * valToCount.get(v));
        }
      } // for v
      valToCount.put(val, count);
      res = safeAdd(res, count);
    }
    return res;
  }

  private static int safeAdd(long a, long b) {
    return (int) ((a + b) % MOD);
  }
}
