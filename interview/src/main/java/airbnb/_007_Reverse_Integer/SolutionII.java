package airbnb._007_Reverse_Integer;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int reverse(int x) {
    if (x == 0) return 0;
    if (x == Integer.MIN_VALUE) return 0;
    if (x < 0) return -reverse(-x);
    int res = 0;
    while (x > 0) {
      final int d = x % 10;
      x /= 10;
      if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10) return 0;
      res = res * 10 + d;
    }
    return res;
  }
}
