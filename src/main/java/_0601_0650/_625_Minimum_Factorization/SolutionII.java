package _0601_0650._625_Minimum_Factorization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int smallestFactorization(int a) {
    assert a > 0;
    if (a == 1) {
      return 1;
    }
    final List<Integer> result = new ArrayList<>();
    while (a != 1) {
      if (a < 10) {
        result.add(a);
        a = 1;
      } else {
        boolean hasFound = false;
        for (int i = 9; i >= 2; --i) {
          if (a % i == 0) {
            result.add(i);
            a /= i;
            hasFound = true;
            break;
          }
        }
        if (!hasFound) {
          return 0;
        }
      }
    }
    int res = 0;
    for (int i = result.size() - 1; i >= 0; --i) {
      final int curDigit = result.get(i);
      if (res > Integer.MAX_VALUE / 10) {
        return 0;
      }
      if (res < Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && curDigit == Integer.MAX_VALUE % 10)) {
        res = res * 10 + result.get(i);
      }
    }
    return res;
  }
}
