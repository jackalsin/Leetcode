package explore.isSubsequence;

/**
 * @author jacka
 * @version 1.0 on 5/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean[] isSubsequence(String[] s, String t) {
    if (s == null || s.length == 0) {
      return new boolean[]{};
    }
    final int n = s.length;
    final boolean[] result = new boolean[n];
    final int[] ptrs = new int[n];
    for (final char tChr : t.toCharArray()) {
      for (int i = 0; i < s.length; ++i) {
        if (ptrs[i] == s[i].length()) {
          result[i] = true;
          continue;
        }
        final char sChr = s[i].charAt(ptrs[i]);
        if (sChr == tChr) ptrs[i]++;
        if (ptrs[i] == s[i].length()) {
          result[i] = true;
        }
      }
    }
    return result;
  }
}
