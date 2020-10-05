package _0851_0900._878_Nth_Magical_Number;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int nthMagicalNumber(int N, int A, int B) {
    final long gcd = gcd(A, B), lcm = A / gcd * B;
    long left = 2L, right = (long) 1E14;
    while (left < right) {
      final long mid = left + (right - left) / 2;
      final long count = mid / A + mid / B - mid / lcm;
      if (count >= N) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return (int) (left % MOD);
  }

  private static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }
    while (b != 0) {
      final int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
}
