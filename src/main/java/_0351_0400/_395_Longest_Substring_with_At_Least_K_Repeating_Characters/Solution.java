package _0351_0400._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

public class Solution {
  public int longestSubstring(String s, final int k) {
    final char[] chars = s.toCharArray();
    int max = 0;
    for (int unique = 1; unique <= 26; unique++) {
      int curUnique = 0, i = 0, j = 0, noLessThanK = 0;
      final int[] counts = new int[26];

      while (j < s.length()) {
        final char chr = chars[j];
        final int idx = chr - 'a';

        if (counts[idx] == 0) {
          curUnique++;
        }
        counts[idx]++;
        if (counts[idx] == k) {
          noLessThanK++;
        }
        j++;
        while (curUnique > unique) {
          final char startChar = chars[i];
          final int startIndex = startChar - 'a';
          counts[startIndex]--;
          if (counts[startIndex] == 0) {
            curUnique--;
          }
          if (counts[startIndex] == k - 1) {
            noLessThanK--;
          }
          i++;
        }

        if (curUnique == unique && noLessThanK == unique) {
          // end of while (curUnique > unique)
          // j 是扫过的+1, i 是正常的开始
          max = Math.max(max, j - i);
//          System.out.println("max = " + max + " i = " + i + " j = " + j + " unique = " + unique);
        }
      }
    }
    return max;
  }
}
