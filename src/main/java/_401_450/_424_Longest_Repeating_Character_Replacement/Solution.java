package _401_450._424_Longest_Repeating_Character_Replacement;

public class Solution {
  /**
   * 37 / 37 test cases passed.
   * Status: Accepted
   * Runtime: 12 ms
   * <p>
   * Time Complexity: O(N)
   *
   * @param s
   * @param k
   * @return
   */
  // todo: submit to leetcode
  public int characterReplacement(String s, int k) {
    int maxLength = 0, maxContinuousCount = 0;
    final int[] counts = new int[26];
    for (int start = 0, end = 0; end < s.length(); end++) {
      maxContinuousCount = Math.max(maxContinuousCount, ++counts[s.charAt(end) - 'A']);

      while (end - start + 1 > k + maxContinuousCount) {
        final char startChar = s.charAt(start);
        counts[startChar - 'A']--;
        start++;
      }

      maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
  }
}
