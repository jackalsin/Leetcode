package _1401_1450._1416_Restore_The_Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
public final class DpSolution2D implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private final Map<Integer, Map<Long, Integer>> iToNumToCount = new HashMap<>();

  public int numberOfArrays(String s, int k) {
    return numberOfArrays(s, k, 0, 0);
  }

  private int numberOfArrays(final String s, final int k, final int i, final long num) {
    if (i == s.length()) {
      return 1;
    }
    final Map<Long, Integer> curMap = iToNumToCount.getOrDefault(i, new HashMap<>());
    iToNumToCount.put(i, curMap);
    if (curMap.containsKey(num)) {
      return curMap.get(num);
    }
    final int curDigit = s.charAt(i) - '0';
    int sum = 0;
    if (1 <= num && num <= k && curDigit != 0) {
      sum = safeAdd(sum, numberOfArrays(s, k, i + 1, curDigit));
    }
    final long next = num * 10 + curDigit;
    if (1 <= next && next <= k) {
      sum = safeAdd(sum, numberOfArrays(s, k, i + 1, next));
    }
    curMap.put(num, sum);
    return sum;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
