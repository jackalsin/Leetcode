package _1001_1050._1015_Numbers_With_1_Repeated_Digit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class Solution {

  public int numDupDigitsAtMostN(int N) {
    assert 1 <= N && N <= 1E9;
    final LinkedList<Integer> num = new LinkedList<>();
    for (int n = N + 1; n > 0; n /= 10) {
      num.add(0, n % 10);
    }

    int res = 0;
    // count the number with digits < N
    for (int i = 1; i < num.size(); i++) {
      // i 表示位数，首位9种选择，后面的permutation
      res += 9 * permutation(9, i - 1);
    }

    // 位数相同的
    final Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < num.size(); i++) {
      final int curDigit = num.get(i);
      // i + 1 已经用过了
      for (int j = (i == 0 ? 1 : 0); j < curDigit; j++) {
        if (!seen.contains(j)) {
          res += permutation(9 - i, num.size() - i - 1);
        }
      }
      if (seen.contains(curDigit)) break;
      seen.add(curDigit);
    }
    return N - res;
  }

  private static int permutation(final int n, final int m) {
    if (m == 0) {
      return 1;
    }
    return n * permutation(n - 1, m - 1);
  }
}
