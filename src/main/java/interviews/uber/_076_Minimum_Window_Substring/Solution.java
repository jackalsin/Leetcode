package interviews.uber._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public class Solution {
  private static final int N = 256;

  /**
   * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
   * <p>
   * For example,
   * S = "ADOBECODEBANC"
   * T = "ABC"
   * Minimum window is "BANC".
   * <p>
   * Note:
   * If there is no such window in S that covers all characters in T, return the empty string "".
   * <p>
   * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
   *
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    final int[] charCounts = new int[N];
    for (final char chr : t.toCharArray()) {
      charCounts[chr]++;
    }
    int minLen = Integer.MAX_VALUE, start = 0, end = 0, minStart = 0, count = t.length();
    for (; end < s.length(); end++) {
      if (charCounts[s.charAt(end)]-- > 0) {
        count--;
      }
      while (count == 0) {
        if (end - start + 1 < minLen) {
          minLen = end - start + 1;
          minStart = start;
        }
        /* 非<code>t</code>里面的char，在++之前，会始终保持小于0
         * 而 <code>== 0 </code>只可能是刚刚好是那个miss的char
         */
        if (charCounts[(int) s.charAt(start++)]++ == 0) count++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }
}
