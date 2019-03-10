package _1001_1050._1006_Clumsy_Factorial;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class O1Solution implements Solution {
  public int clumsy(int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    if (N == 2) return 2;
    if (N == 3) return 6;
    return N * (N - 1) / (N - 2) + helper(N - 3);
  }

  private int helper(final int N) {
    if (N == 0) return 0;
    if (N == 1) return 1;
    if (N == 2) return 1;
    if (N == 3) return 1;
    if (N == 4) return -2;
    if (N == 5) return 0;
    return helper((N - 2) % 4 + 2);
  }
}
