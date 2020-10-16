package _1001_1050._1002_Find_Common_Characters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> commonChars(String[] A) {

    final List<String> result = new ArrayList<>();
    if (A == null || A.length == 0) {
      return result;
    }
    final int[] counts = getCount(A[0]);
    for (int j = 1; j < A.length; j++) {
      final String str = A[j];
      final int[] curCount = getCount(str);
      for (int i = 0; i < 26; ++i) {
        counts[i] = Math.min(counts[i], curCount[i]);
      }
    }
    for (int i = 0; i < 26; ++i) {
      final char chr = (char) (i + 'a');
      for (int k = 0; k < counts[i]; ++k) {
        result.add(String.valueOf(chr));
      }
    }
    return result;
  }

  private static int[] getCount(final String str) {
    final int[] result = new int[26];
    for (final char chr : str.toCharArray()) {
      result[chr - 'a']++;
    }
    return result;
  }
}
