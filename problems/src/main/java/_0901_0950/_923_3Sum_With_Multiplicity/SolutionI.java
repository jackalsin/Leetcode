package _0901_0950._923_3Sum_With_Multiplicity;

/**
 * @author jacka
 * @version 1.0 on 9/20/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int threeSumMulti(int[] A, int target) {
    final long[] counts = new long[101];
    for (int a : A) {
      counts[a]++;
    }

    int result = 0;

    for (int i = 0; i < 101; ++i) {
      for (int j = i; j < 101; ++j) {
        final int k = target - i - j;
        if (k < 0 || k > 100) continue;
        if (i == j && j == k) {
          result = safeAdd(result, counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6);
        } else if (i == j) {
          result = safeAdd(result, counts[i] * (counts[j] - 1) * counts[k] / 2);
        } else if (j < k) {
          result = safeAdd(result, counts[i] * counts[j] * counts[k]);
        }
      }
    }
    return result;
  }

  private static int safeAdd(final long a, final long b) {
    return (int) ((a + b) % MOD);
  }

}
