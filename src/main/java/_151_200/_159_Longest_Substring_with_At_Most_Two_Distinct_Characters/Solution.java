package _151_200._159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.length() == 0) return 0;
    char one = s.charAt(0), two = s.charAt(0);
    int oneStart = 0, oneEnd = 0, twoEnd = 0;
    for (int i = 1; i < s.length(); i++) {
      if (one != s.charAt(i)) {
        two = s.charAt(i);
        twoEnd = i;
        break;
      } else {
        oneEnd = i;
      }
    }
    int max = Math.max(twoEnd, oneEnd)- oneStart + 1;
    for (int i = twoEnd + 1; i < s.length(); i++) {
      char curChar = s.charAt(i);
      if (curChar == one) {
        oneEnd = i;
      } else if (curChar == two) {
        twoEnd = i;
      } else {
        max = Math.max(i - oneStart, max);
        if (oneEnd < twoEnd) {
          one = two;
          oneStart = oneEnd + 1;
          oneEnd = twoEnd;
        } else {
          oneStart = twoEnd + 1;
        }
        two = curChar;
        twoEnd = i;
      }
    }
    return Math.max(max, Math.max(oneEnd, twoEnd) - oneStart + 1);
  }
}
