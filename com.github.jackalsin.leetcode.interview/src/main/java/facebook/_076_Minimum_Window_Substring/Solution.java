package facebook._076_Minimum_Window_Substring;

public class Solution {
  public String minWindow(String s, String t) {
    final int[] map = new int[128];
    for (final char chr : t.toCharArray()) {
      map[chr]++;
    }

    int left = 0, right = 0, counters = t.length(), len = Integer.MAX_VALUE, minStart = 0;
    for (; right < s.length(); right++) {
      final char chr = s.charAt(right);
      if (map[chr]-- > 0) {
        counters--;
      }

      while (counters == 0) {
        if (right - left + 1 < len) {
          minStart = left;
          len = right - left + 1;
        }

        if (map[s.charAt(left++)]++ == 0) {
          counters++;
        }
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + len);
  }
}
