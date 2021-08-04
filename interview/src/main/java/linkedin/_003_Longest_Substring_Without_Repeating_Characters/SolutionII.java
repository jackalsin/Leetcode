package linkedin._003_Longest_Substring_Without_Repeating_Characters;

public final class SolutionII implements Solution {
  @Override
  public int lengthOfLongestSubstring(String s) {
    final char[] chars = s.toCharArray();
    final boolean[] used = new boolean[256];
    int max = 0;
    for (int left = 0, right = 0; right < s.length(); ++right) {
      final char chr = chars[right];
      final int chrIndex = chr;
      while (used[chrIndex]) {
        final int leftChrIndex = chars[left];
        used[leftChrIndex] = false;
        left++;
      }
      used[chrIndex] = true;
      max = Math.max(right - left + 1, max);
    }
    return max;
  }
}
