package google._792_Number_of_Matching_Subsequences;

/**
 * @author jacka
 * @version 1.0 on 5/3/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int numMatchingSubseq(String S, String[] words) {
    int count = 0;
    final char[] chars = S.toCharArray();
    for (final String word : words) {
      if (isSubsequence(chars, word)) count++;
    }
    return count;
  }

  private static boolean isSubsequence(final char[] chars, final String word) {
    final char[] wordChars = word.toCharArray();
    int j = 0;
    for (int i = 0; i < chars.length; ++i) {
      if (wordChars[j] == chars[i]) ++j;
      if (j == wordChars.length) return true;
    }
    return false;
  }
}
