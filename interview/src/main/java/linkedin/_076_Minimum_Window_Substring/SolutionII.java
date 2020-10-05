package linkedin._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public final class SolutionII implements Solution {
  public String minWindow(String s, String t) {
    final int[] counts = new int[256];
    for (char chr : t.toCharArray()) {
      counts[chr]++;
    }

    int count = t.length(), left = 0, right = 0, minStart = 0, minEnd = Integer.MAX_VALUE - 1;

    while (right < s.length()) {
      if (counts[s.charAt(right)]-- > 0) {
        count--;
      }
      right++;
      while (count == 0 && left < right) {
        final char startChar = s.charAt(left);

        if (minEnd - minStart + 1 >= right - left) {
          System.out.println("Start = " + left + ", end " + right);
          minEnd = right - 1;
          minStart = left;
        }

        if (counts[startChar]++ == 0) {
          count++;
        }

        left++;
      }
    }

    return (minEnd == Integer.MAX_VALUE - 1) ? "" : s.substring(minStart, minEnd + 1);
  }
}
