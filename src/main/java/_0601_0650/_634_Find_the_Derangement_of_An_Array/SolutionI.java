package _0601_0650._634_Find_the_Derangement_of_An_Array;

/**
 * @author zhixi
 * @version 1.0 on 3/13/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int findDerangement(int n) {
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }
    /*对于任何 n
     * 在第一位我有(n - 1) 种选择，假设选择i，那么
     * 1） 如果 i 选择了1，那么剩下就相当于 n-2个选择n-2个位置
     * 2） 如果不选择1，那么相当于n - 1 选择 n - 1 个位置
     */
    long prev1 = 2, prev2 = 1;
    for (int i = 4; i <= n; i++) {
      final long nextPrev1 = (prev1 + prev2) * (i - 1) % MOD;
      prev2 = prev1;
      prev1 = nextPrev1;
    }
    return (int) prev1;
  }
}
