package _0551_0600._598_Range_Addition_II;

/**
 * @author jacka
 * @version 1.0 on 3/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxCount(int m, int n, int[][] ops) {
    for (final int[] op : ops) {
      m = Math.min(m, op[0]);
      n = Math.min(n, op[1]);
    }
    return m * n;
  }
}
