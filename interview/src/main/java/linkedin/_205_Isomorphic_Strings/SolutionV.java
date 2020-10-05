package linkedin._205_Isomorphic_Strings;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionV implements Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }
    final int[] normalizedS = getNormalizedChar(s),
        normalizedT = getNormalizedChar(t);
    return Arrays.equals(normalizedS, normalizedT);
  }

  private static int[] getNormalizedChar(final String s) {
    final int[] map = new int[256];
    int count = 1;
    final int[] res = new int[s.length()];
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (map[chr] == 0) {
        map[chr] = count++;
      }
      res[i] = map[chr];
    }
    return res;
  }
}
