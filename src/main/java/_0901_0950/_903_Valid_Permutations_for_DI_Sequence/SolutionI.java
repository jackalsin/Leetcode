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
  private final Map<Long, Integer> cache = new HashMap<>();
  private int[][] nCk;

  public int numPermsDISequence(String s) {
    final int n = s.length();
    nCk = new int[n + 1][n + 1];
    return numPermsDISequenceHelper(s.toCharArray(), 0, n - 1);
  }

  private int numPermsDISequenceHelper(final char[] chars, final int start, final int end) {
//    System.out.printf("Start = %d, end = %d\n", start, end);
    final int n = end - start + 1;
    assert n >= 0;
    if (n == 0) {
      return 1;
    }
    final long key = getKey(start, end);
    if (cache.containsKey(key)) return cache.get(key);
    int result = 0;
    // if the max is at the head
    if (chars[start] == D) {
      result = safeAdd(result, numPermsDISequenceHelper(chars, start + 1, end));
    }
    // if max is in the end
    if (chars[end] == I) {
      result = safeAdd(result, numPermsDISequenceHelper(chars, start, end - 1));
    }
    // in the middle
    for (int i = start; i < end; ++i) {
      if (chars[i] == I && chars[i + 1] == D) {
        final int left = numPermsDISequenceHelper(chars, start, i - 1),
            right = numPermsDISequenceHelper(chars, i + 2, end),
            nCk = combination(n, i - start + 1);
        result = safeAdd(result, ((long) left * right % MOD) * nCk);
      }
    }
    cache.put(key, result);
    return result;
  }

  private static long getKey(long start, long end) {
    return start << 32 | end;
  }

  private int combination(final int n, int i) {
//    System.out.printf("n = %d, i = %d\n", n, i);
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
