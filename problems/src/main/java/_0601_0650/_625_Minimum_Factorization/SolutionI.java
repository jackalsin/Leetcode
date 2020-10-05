package _0601_0650._625_Minimum_Factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int smallestFactorization(int a) {
    if (a < 10) {
      return a;
    }
    final List<Integer> result = new ArrayList<>();
    // try every factor as much as possible
    for (int i = 9; i > 1; --i) {
      while (a % i == 0) {
        result.add(i);
        a /= i;
      }
    }
    if (a != 1) return 0; // can not form
    long res = 0;
    for (int i = result.size() - 1; i >= 0; --i) {
      res = res * 10 + result.get(i);
      if (res > Integer.MAX_VALUE) {
        return 0;
      }
    }
    return (int) res;
  }
}
