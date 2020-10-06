package _0951_1000._967_Numbers_With_Same_Consecutive_Differences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 10/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] numsSameConsecDiff(int n, int k) {
    final List<Integer> result = new ArrayList<>();
    for (int val = 1; val < 10; ++val) {
      dfs(result, val, n, k, 1);
    }
    return result.stream().mapToInt(x -> x).toArray();
  }

  private static void dfs(final List<Integer> result, final long val, final int n, final int k,
                          final int i) {
    if (i == n) {
      if (val <= Integer.MAX_VALUE) {
        result.add((int) val);
      }
      return;
    }
    final int lastDigit = (int) (val % 10),
        add = lastDigit + k,
        minus = lastDigit - k;

    if (add >= 0 && add < 10) {
      dfs(result, val * 10 + add, n, k, i + 1);
    }
    if (add != minus && minus >= 0) {
      dfs(result, val * 10 + minus, n, k, i + 1);
    }
  }
}
