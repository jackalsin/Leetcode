package _0551_0600._600_Non_negative_Integers_without_Consecutive_Ones;

/**
 * @author jacka
 * @version 1.0 on 3/2/2020
 */
public final class SolutionI implements Solution {
  /*
   * 初步观察可得：Denote f(k) 为有k位bit时，有多少符合没有consecutive 1s的数
   * 1. if k = 5, we have range [00_000, 11_111]
   * 1.1 [00_000, 01_111] is f(4)
   * 1.2 [10_000, 10_111] is f(3)
   * 1.3 [11_000, 11_111] should never be part of it
   */

  private static final int[] F = new int[32];

  static {
    F[0] = 1;
    F[1] = 2;
    for (int i = 2; i < 32; ++i) {
      F[i] = F[i - 1] + F[i - 2];
    }
//    System.out.println(Arrays.toString(F));
  }

  public int findIntegers(int num) {
//    System.out.println(Integer.toBinaryString(num));
    int res = 0, preBit = 0;
    for (int bit = (1 << 31), i = 31; i >= 0; --i, bit >>>= 1) {
      if ((num & bit) != 0) {
        res += F[i];
        if (preBit == 1) return res;
        preBit = 1;
      } else {
        preBit = 0;
      }
    }
    return res + 1;
  }
}
