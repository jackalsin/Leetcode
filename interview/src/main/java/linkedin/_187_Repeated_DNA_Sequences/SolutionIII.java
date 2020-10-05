package linkedin._187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/6/2019
 */
public final class SolutionIII implements Solution {
  private static final int N = 10;
  private static final int[] CHAR_TO_INT = new int[128];

  static {
    CHAR_TO_INT['A'] = 0;
    CHAR_TO_INT['C'] = 1;
    CHAR_TO_INT['T'] = 2;
    CHAR_TO_INT['G'] = 3;
  }

  private static final int BASE;

  static {
    int res = 0;
    for (int i = 0; i < N; i++) {
      res = (res << 2) | 0b11;
    }
    BASE = res;
  }

  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() < N) {
      return new ArrayList<>();
    }
    final Set<Integer> visited = new HashSet<>();
    final Set<String> dup = new HashSet<>();
    final char[] chars = s.toCharArray();
    int curSubsequenceKey = 0;
    for (int i = 0; i < N; i++) {
      curSubsequenceKey = curSubsequenceKey << 2 | CHAR_TO_INT[chars[i]];
    }
    visited.add(curSubsequenceKey);
    for (int i = N; i < s.length(); i++) {
      final char chr = chars[i];
      curSubsequenceKey = ((curSubsequenceKey << 2) | CHAR_TO_INT[chr]) & BASE;
      if (visited.contains(curSubsequenceKey)) {
        dup.add(String.valueOf(chars, i - 9, 10));
      } else {
        visited.add(curSubsequenceKey);
      }
    }
    return new ArrayList<>(dup);
  }

}
