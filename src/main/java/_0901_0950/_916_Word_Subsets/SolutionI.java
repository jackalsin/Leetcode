package _0901_0950._916_Word_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {

  @Override
  public List<String> wordSubsets(String[] A, String[] B) {
    final int[] required = getRequired(B);
    final List<String> result = new ArrayList<>();
    for (final String a : A) {
      if (isUniversal(a, required)) {
        result.add(a);
      }
    }
    return result;
  }

  private static boolean isUniversal(final String s, final int[] required) {
    final int[] curCharMap = getCharMap(s);
    for (int i = 0; i < 26; ++i) {
      final int actual = curCharMap[i],
          need = required[i];
      if (actual < need) {
        return false;
      }
    } // end of checking if the word is Universal
    return true;
  }

  private static int[] getRequired(final String[] b) {
    final int[] result = new int[26];
    for (final String c : b) {
      final int[] cur = getCharMap(c);
      for (int i = 0; i < cur.length; ++i) {
        result[i] = Math.max(cur[i], result[i]);
      }
    }
    return result;
  }

  private static int[] getCharMap(final String s) {
    final int[] result = new int[26];
    for (final char chr : s.toCharArray()) {
      result[chr - A]++;
    }
    return result;
  }

  private static final char A = 'a';
}
