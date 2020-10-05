package _1201_1250._1201_Ugly_Number_III;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int nthUglyNumber(int n, int a, int b, int c) {
    int left = 1, right = Integer.MAX_VALUE;
    final long ab = (long) a * b / gcd(a, b),
        ac = (long) a * c / gcd(a, c), bc = (long) b * c / gcd(b, c),
        abc = ab * c / gcd(ab, c);
    while (left < right) {
      final int mid = left + (right - left) / 2;
      final long count = mid / a + mid / b + mid / c
          - mid / ab - mid / bc - mid / ac + mid / abc;
      if (count >= n) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private static long gcd(long a, long b) {
    if (a < b) {
      return gcd(b, a);
    }
    while (b != 0) {
      final long c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
}
