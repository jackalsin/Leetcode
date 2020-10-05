package _1401_1450._1411_Number_of_Ways_to_Paint_N_3_Grid;

public final class SolutionI implements Solution {
  private static final int MOD = (int) (1e9 + 7);

  public int numOfWays(int n) {
    if (n == 1) return 12;
    long a121 = 6, a123 = 6;
    for (int i = 1; i < n; ++i) {
      final long b121 = a121 * 3 + a123 * 2,
          b123 = 2 * a121 + a123 * 2;
      a121 = b121 % MOD;
      a123 = b123 % MOD;
    }
    return safeAdd(a121, a123);
  }

  private static int safeAdd(long a, final long... b) {
    for (long c : b) {
      a = (a + c) % MOD;
    }
    return (int) a;
  }
}
