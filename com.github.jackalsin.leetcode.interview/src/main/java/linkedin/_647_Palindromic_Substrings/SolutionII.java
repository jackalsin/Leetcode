package linkedin._647_Palindromic_Substrings;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int countSubstrings(String s) {
    if (s == null) {
      return 0;
    }
    final char[] chars = s.toCharArray();
    int res = 0;
    for (int i = 0; i < chars.length; ++i) {
      res += extend(chars, i, i);
      res += extend(chars, i, i + 1);
    }
    return res;
  }

  private static int extend(final char[] chars, int i, int j) {
    int res = 0;
    while (i >= 0 && j < chars.length) {
      if (chars[i] == chars[j]) {
        res++;
      } else {
        break;
      }
      --i;
      ++j;
    }
    return res;
  }
}
