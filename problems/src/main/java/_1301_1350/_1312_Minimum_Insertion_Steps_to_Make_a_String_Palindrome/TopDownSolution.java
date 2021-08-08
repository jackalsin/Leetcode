package _1301_1350._1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

import java.util.HashMap;
import java.util.Map;

public final class TopDownSolution implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();

  public int minInsertions(String s) {
    return minInsertion(s, 0, s.length() - 1);
  }

  private int minInsertion(final String s, final int left, final int right) {
    if (left >= right) return 0;
    final int key = getKey(left, right);
    if (cache.containsKey(key)) return cache.get(key);
    final char leftChar = s.charAt(left), rightChar = s.charAt(right);
    if (leftChar == rightChar) {
      final int res = minInsertion(s, left + 1, right - 1);
      cache.put(key, res);
      return res;
    }
    final int res = 1 + Math.min(minInsertion(s, left + 1, right), minInsertion(s, left, right - 1));
    cache.put(key, res);
    return res;
  }

  private static int getKey(final int left, final int right) {
    return left << 10 | right;
  }
}
