package _0051_0100._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
public class Solution {

  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() <= t.length()) {
      return "";
    }
    int[] map = new int[256];
    int count = t.length(), start = 0, end = 0, len = Integer.MAX_VALUE, minStart = 0;
    for (int i = 0; i < t.length(); i++) {
      map[(int) t.charAt(i)]++;
    }
    while (end < s.length()) {
      if (map[(int) s.charAt(end++)]-- > 0)
        count--;
      while (count == 0) {
        if (end - start < len) {
          len = end - start;
          minStart = start;
        }
        if (map[(int) s.charAt(start++)]++ == 0) count++;
      }
    }
    return len == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + len);
  }
}
