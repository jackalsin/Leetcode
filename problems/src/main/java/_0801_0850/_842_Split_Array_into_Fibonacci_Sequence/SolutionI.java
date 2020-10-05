package _0801_0850._842_Split_Array_into_Fibonacci_Sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> splitIntoFibonacci(String s) {
    final List<Integer> result = new ArrayList<>();
    long prev1 = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(0) == '0' && i > 0) break;
      final char c1 = s.charAt(i);
      prev1 = prev1 * 10 + c1 - '0';
      if (prev1 <= Integer.MAX_VALUE) {
        result.add((int) prev1);

        // pick prev2
        long prev2 = 0L;
        for (int j = i + 1; j < s.length(); ++j) {
          if (s.charAt(i + 1) == '0' && j > i + 1) break;
          final char c2 = s.charAt(j);
          prev2 = prev2 * 10 + c2 - '0';
          if (prev2 > Integer.MAX_VALUE) break;
          result.add((int) prev2);
//          System.out.println("prev1 = " + prev1 + ", prev2 = " + prev2);
          if (dfs(result, s, j + 1, prev1, prev2)) {
//            System.out.println("Found = " + result);
            return result;
          }
          result.remove(1);
        }
        result.remove(0);
      }
    }
    return result;
  }

  private static boolean dfs(final List<Integer> result, final String s, final int start,
                             final long prev1, final long prev2) {
    assert start <= s.length();
    if (start == s.length()) {
      return result.size() > 2;
    }
    final long expected = prev1 + prev2;
    if (expected > Integer.MAX_VALUE) return false;
    final String expectedString = Long.toString(expected);
    if (s.startsWith(expectedString, start)) {
      result.add((int) expected);
      if (dfs(result, s, start + expectedString.length(), prev2, expected)) {
        return true;
      }
      result.remove(result.size() - 1);
    }
    return false;
  }
}
