package linkedin._007_Reverse_Integer;

public final class SolutionIII implements Solution {
  @Override
  public int reverse(int x) {
    if (x == Integer.MIN_VALUE) return 0;
    if (x == 0) return 0;
    if (x < 0) return -reverse(-x);
    int res = 0;
    while (x != 0) {
      if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) return 0;
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res;
  }
}
