package interviews.microsoft.noodleEssence._409_Longest_Palindrome;

public class Solution {
  public int longestPalindrome(String s) {
    final int[] counts = new int[256];
    int maxLen = 0;
    int oddCount = 0;
    for (char chr : s.toCharArray()) {
      if (counts[chr] == 0) {
        counts[chr]++;
        oddCount++;
      } else {
        maxLen += 2;
        counts[chr]--;
        oddCount--;
      }
    }

    return maxLen + (oddCount != 0 ? 1 : 0);
  }

}
