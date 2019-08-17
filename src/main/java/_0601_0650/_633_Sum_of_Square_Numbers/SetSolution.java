package _0601_0650._633_Sum_of_Square_Numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/17/2019
 */
public final class SetSolution implements Solution {
  @Override
  public boolean judgeSquareSum(int c) {
    if (c < 0) {
      return false;
    }
    final Set<Integer> validSquare = new HashSet<>();
    for (long i = 0; i * i < c; ++i) {
      final long prod = i * i;
      if (prod > Integer.MAX_VALUE) return false;
      final int normalizedProd = (int) prod;
      validSquare.add((int) prod);
      if (validSquare.contains(c - normalizedProd)) return true;
    }
    return false;
  }
}
