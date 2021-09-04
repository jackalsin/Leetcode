package airbnb._1554_Strings_Differ_by_One_Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/3/2021
 */
public final class SolutionI implements Solution {
  private static final long MOD = (long) (1E9 + 7);
  private static final char A = 'a';

  public boolean differByOne(String[] dict) {
    final int len = dict.length, sLen = dict[0].length();
    final int[] hash = new int[len];
    for (int i = 0; i < len; ++i) {
      final char[] chars = dict[i].toCharArray();
      for (final char c : chars) {
        hash[i] = (int) ((hash[i] * 26L + c - A) % MOD);
      }
    }
    for (int j = sLen - 1, mul = 1; j >= 0; --j, mul = (int) (mul * 26L % MOD)) {
      final Map<Integer, List<Integer>> hashMap = new HashMap<>();
      for (int i = 0; i < len; ++i) {
        final char c = dict[i].charAt(j);
        final int h = (int) ((MOD + hash[i] - ((long) mul * (c - A) % MOD)) % MOD);
        final List<Integer> indexList = hashMap.computeIfAbsent(h, k -> new ArrayList<>());
        for (int index : indexList) {
          if (equals(dict[index], dict[i], j)) {
            return true;
          }
        } // end of
        indexList.add(i);
      }
    }
    return false;
  }

  private static boolean equals(final String s1, final String s2, final int excludeIndex) {
    for (int i = 0; i < s1.length(); ++i) {
      if (i == excludeIndex) continue;
      final char c1 = s1.charAt(i), c2 = s2.charAt(i);
      if (c1 != c2) return false;
    }
    return true;
  }
}
