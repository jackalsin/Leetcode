package _1551_1600._1554_Strings_Differ_by_One_Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/12/2021
 */
public final class RobinKarpSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7), A = 'a';

  public boolean differByOne(String[] dict) {
    final int len = dict.length, strLen = dict[0].length();
    final int[] hash = new int[len];
    for (int i = 0; i < len; i++) {
      final char[] chars = dict[i].toCharArray();
      for (int j = 0; j < chars.length; ++j) {
        hash[i] = (int) ((hash[i] * 26L + chars[j] - A) % MOD);
      }
    }

    for (int j = strLen - 1, mul = 1; j >= 0; --j) {
      final Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < len; ++i) {
        final char c = dict[i].charAt(j);
        final int h = (int) ((MOD + hash[i] - ((long) mul * (c - A) % MOD)) % MOD);
        final List<Integer> indexList = map.getOrDefault(h, new ArrayList<>());
        for (int index : indexList) {
          if (equals(dict[index], dict[i], j)) return true;
        }
        indexList.add(i);
        map.put(h, indexList);
      }
      mul = (int) (26L * mul % MOD);
    }

    return false;
  }

  private static boolean equals(final String s1, final String s2, final int excludeIndex) {
    for (int i = 0; i < s1.length(); ++i) {
      final char c1 = s1.charAt(i), c2 = s2.charAt(i);
      if (i != excludeIndex) {
        if (c1 != c2) return false;
      }
    }
    return true;
  }
}
