package _1351_1400._1392_Longest_Happy_Prefix;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String longestPrefix(String str) {
    if (str == null || str.length() < 2) {
      return "";
    }
    int n = str.length();
    final char[] s = str.toCharArray();
    final int[] next = new int[n];
    next[0] = 0;
    int len = 0;

    for (int i = 1; i < n; ) {
      if (s[i] == s[len]) {
        len++;
        next[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = next[len - 1];
        } else {  // len == 0
          next[i] = 0;
          i++;
        }
      }
    }
    return str.substring(0, next[next.length - 1]);
  }
}
