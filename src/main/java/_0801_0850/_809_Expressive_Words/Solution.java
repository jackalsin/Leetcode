package _0801_0850._809_Expressive_Words;

public final class Solution {
  public int expressiveWords(String S, String[] words) {
    int result = 0;
    for (final String word : words) {
      if (isExpressiveWord(word, S)) {
        result++;
      }
    }
    return result;
  }

  private static boolean isExpressiveWord(final String w, final String s) {
    int j = 0;
    final int m = w.length(), n = s.length();
    for (int i = 0; i < n; i++) {
      if (j < m && s.charAt(i) == w.charAt(j)) j++;
        // skip if it's the last of three
      else if (i > 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)
          // skip if it's the 2nd of three
          || i > 0 && i < n - 1 && s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == s.charAt(i + 1)) ;
      else return false;
    }
    return j == m;
  }
}
