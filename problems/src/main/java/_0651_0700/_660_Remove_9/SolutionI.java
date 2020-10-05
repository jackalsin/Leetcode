package _0651_0700._660_Remove_9;

/**
 * @author zhixi
 * @version 1.0 on 3/9/2020
 */
public final class SolutionI implements Solution {
  private static final int[] CACHE = new int[10];

  static {
    CACHE[0] = 1;
    for (int i = 1; i < 10; ++i) {
      CACHE[i] = 9 * CACHE[i - 1];
    }
  }

  public int newInteger(int n) {
    assert n > 0;
    int res = 0;
    for (int i = 9, mod = 1_000_000_000; i >= 0 && n > 0; --i, mod /= 10) {
      final int digit = n / CACHE[i];
      res += digit * mod;
      n -= digit * CACHE[i];
    }
    return res;
  }
}
