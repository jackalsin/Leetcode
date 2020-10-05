package _0351_0400._372_Super_Pow;

public class Solution {
  private static final int MOD = 1337;

  public int superPow(int a, int[] b) {
    return superPow(a, b, b.length - 1);
  }

  private int superPow(int a, int[] b, int lastIndex) {
    if (lastIndex == -1) {
      return 1;
    }

    return (superMod(superPow(a, b, lastIndex - 1), 10) * superMod(a, b[lastIndex])) % MOD;
  }

  private int superMod(int a, int power) {
    int res = 1;
    while (power != 0) {
      res = ((res % MOD) * (a % MOD)) % MOD;
      power--;
    }
    return res;
  }
}
