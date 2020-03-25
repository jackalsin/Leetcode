package _1001_1050._1011_Capacity_To_Ship_Packages_Within_D_Days;

/**
 * @author jacka
 * @version 1.0 on 3/24/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int shipWithinDays(int[] weights, int D) {
    final long[] maxSumPair = getMaxSum(weights);
    long left = maxSumPair[0], right = maxSumPair[1];
    while (left < right) {
      final long mid = (left + right) / 2;
      final int count = getCount(weights, mid);
      if (count > D) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return (int) left;
  }

  static int getCount(final int[] weights, final long capacity) {
    int count = 1, cur = 0;
    for (int w : weights) {
      if (w + cur > capacity) {
        count++;
        cur = w;
      } else {
        cur += w;
      }
    }
    return count;
  }

  private static long[] getMaxSum(final int[] weights) {
    long sum = 0, max = 0;
    for (int w : weights) {
      sum += w;
      max = Math.max(max, w);
    }
    return new long[]{max, sum};
  }
}
