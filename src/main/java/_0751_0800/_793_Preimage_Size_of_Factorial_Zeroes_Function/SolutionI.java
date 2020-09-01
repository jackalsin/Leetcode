package _0751_0800._793_Preimage_Size_of_Factorial_Zeroes_Function;

/**
 * @author zhixi
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int preimageSizeFZF(int K) {
    long left = 0, right = (K + 1) * 5L;
    while (left <= right) {
      final long mid = left + (right - left) / 2;
      final int midVal = trailingZeros(mid);
      if (midVal < K) {
        left = mid + 1;
      } else if (midVal > K) {
        right = mid - 1;
      } else {
        return 5;
      }
    }
    return 0;
  }

  private static int trailingZeros(long val) {
    int result = 0;
    while (val > 0) {
      result += val / 5;
      val /= 5;
    }
    return result;
  }
}
