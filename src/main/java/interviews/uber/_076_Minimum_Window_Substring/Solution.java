package interviews.uber._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public class Solution {
  private static final int N = 26;
  private static final char BASE = 'A';

  public String minWindow(String s, String t) {
    final int[] charCounts = new int[N];
    for (final char chr : t.toCharArray()) {
      charCounts[chr - BASE]++;
    }
    int minLen = Integer.MAX_VALUE, minStart = 0, start = 0, end = 0, count = t.length();
    while (end < s.length()) {
      if (charCounts[s.charAt(end++) - BASE]-- > 0) {
//        charCounts[s.charAt(end) - BASE]--;
        count--;
      }

      while (count == 0) {
        if (end - start < minLen) {
          minStart = start;
          minLen = end - start;
        }
        if (charCounts[s.charAt(start++) - BASE]++ == 0) {
          count++;
        }
//        charCounts[s.charAt(start) - BASE]++;
//        start++;
      }
//      end++;
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }
}
