package _0851_0900._858_Mirror_Reflection;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
public class Solution {
  public int mirrorReflection(int p, int q) {
    final int div = gcd(p, q);
    final int x = p / div, y = q / div;
    if (y % 2 == 0) {
      return 0;
    } else if (x % 2 == 1) {
      return 1;
    } else {
      return 2;
    }
  }

  private static int gcd(int p, int q) {
    if (p < q) {
      return gcd(q, p);
    }
    while (q != 0) {
      final int d = p % q;
      p = q;
      q = d;
    }
    return p;
  }
}
