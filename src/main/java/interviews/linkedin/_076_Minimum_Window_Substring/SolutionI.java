package interviews.linkedin._076_Minimum_Window_Substring;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
public final class SolutionI implements Solution {
  public String minWindow(String s, String t) {
    final int[] counts = new int[256];
    for (char chr : t.toCharArray()) {
      counts[chr]++;
    }
    int count = t.length(), maxStart = 0, maxEnd = Integer.MAX_VALUE, left = 0, right = 0;
    while (right < s.length()) {
      if (counts[s.charAt(right)]-- > 0) {
        count--;
      }
      while (count == 0) {
        if ((right - left) <= (maxEnd - maxStart)) {
          maxStart = left;
          maxEnd = right;
        }
        if (++counts[s.charAt(left++)] > 0) {
          count++;
        }
      }
      right++;
    }
    return maxEnd == Integer.MAX_VALUE ? "" : s.substring(maxStart, maxEnd + 1);
  }
}
