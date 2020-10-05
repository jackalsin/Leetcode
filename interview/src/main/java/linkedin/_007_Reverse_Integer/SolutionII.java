package linkedin._007_Reverse_Integer;

public final class SolutionII implements Solution {
  public int reverse(int x) {
    if (x == 0) {
      return 0;
    } else if (x == Integer.MIN_VALUE) {
      return 0;
    }
    final int sign = x < 0 ? -1 : 1;
    int val = Math.abs(x), res = 0;
    while (val != 0) {
      if (res > Integer.MAX_VALUE / 10 ||
          (res == Integer.MAX_VALUE / 10 && val > Integer.MAX_VALUE % 10)) {
        return 0;
      }
      final int cur = val % 10;
      res = res * 10 + cur;
      val /= 10;
    }
    return sign * res;
  }
}
