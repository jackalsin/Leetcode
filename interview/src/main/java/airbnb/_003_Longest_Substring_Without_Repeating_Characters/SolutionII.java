package airbnb._003_Longest_Substring_Without_Repeating_Characters;

public final class SolutionII implements Solution {
  @Override
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) return 0;
    final int n = s.length();
    final boolean[] used = new boolean[256];
    final char[] chars = s.toCharArray();
    int max = 0;
    for (int left = 0, right = 0; right < n; ++right) {
      final char rightChar = chars[right];
      while (used[rightChar]) {
        final int leftCharIndex = chars[left];
        used[leftCharIndex] = false;
        left++;
      }
      used[rightChar] = true;
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
