package _0301_0350._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

/**
 * @author jacka
 * @version 1.0 on 10/5/2017.
 */
public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    final int[] count = new int[256];
    int num = 0, start = 0, result = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (count[s.charAt(i)]++ == 0) {
        num++;
      }
      if (num > k) {
        while (--count[s.charAt(start++)] > 0) {
          ;
        }
        num--;
      }

      result = Math.max(result, i - start + 1);
    }
    return result;
  }

}
