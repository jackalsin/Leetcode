package _0901_0950._903_Valid_Permutations_for_DI_Sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/17/2020
 */
public final class SolutionI implements Solution {
  private static final char I = 'I', D = 'D';
  private static final int MOD = (int) (1e9 + 7);
  private final Map<String, Integer> cache = new HashMap<>();
  private int[][] nCk;

  public int numPermsDISequence(String s) {
    final int n = s.length();
    nCk = new int[n + 1][n + 1];
    return numPermsDISequenceHelper(s);
  }

  private int numPermsDISequenceHelper(final String s) {
    if (s.isEmpty()) {
      return 1;
    }
    if (cache.containsKey(s)) return cache.get(s);
    final int n = s.length();
    int result = 0;
    // if the max is at the head
    if (s.charAt(0) == D) {
      result = safeAdd(result, numPermsDISequenceHelper(s.substring(1)));
    }
    // if max is in the end
    if (s.charAt(n - 1) == I) {
      result = safeAdd(result, numPermsDISequenceHelper(s.substring(0, n - 1)));
    }
    // in the middle
    for (int i = 0; i + 1 < n; ++i) {
      if (s.charAt(i) == I && s.charAt(i + 1) == D) {
        final int left = numPermsDISequenceHelper(s.substring(0, i)),
            right = numPermsDISequenceHelper(s.substring(i + 2)),
            nCk = combination(n, i + 1);
        result = safeAdd(result, ((long) left * right % MOD) * nCk);
      }
    }
    cache.put(s, result);
    return result;
  }

  private int combination(final int n, int i) {
    if (nCk[n][i] != 0) {
      return nCk[n][i];
    }
    final int result;
    if (n == i || i == 0) {
      result = 1;
    } else {
      result = safeAdd(combination(n - 1, i - 1), combination(n - 1, i));
    }
    nCk[n][i] = result;
    nCk[n][n - i] = result;
    return result;
  }

  private static int safeAdd(final long a, final long b) {
    return (int) ((a + b) % MOD);
  }
}
