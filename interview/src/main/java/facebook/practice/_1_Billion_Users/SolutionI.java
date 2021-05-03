package facebook.practice._1_Billion_Users;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  private static final double SUM = 1_000_000_000;

  public int getBillionUsersDay(float[] growthRates) {
    int left = 1, right = Integer.MAX_VALUE;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      final double sum = sum(growthRates, mid);
      if (sum >= SUM) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static double sum(final float[] growthRates, final int t) {
    double res = 0;
    for (final double g : growthRates) {
      res += Math.pow(g, t);
    }
    return res;
  }
}
