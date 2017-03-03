package _001_050._028_Implement_strStr;

/**
 * @author jacka
 * @version 1.0 on 1/24/2017.
 */
public class Solution {
  /**
   * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
   * @param haystack  the original String
   * @param needle    the string to find
   * @return          the index of the first occurrence of needle in haystack
   */
  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
      return -1;
    } else {
      for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        boolean isMatch = true;
        for (int j = 0; j < needle.length(); j++) {
          if (haystack.charAt(i + j) != needle.charAt(j)) {
            isMatch = false;
          }
        }
        if (isMatch) return i;
      }
      return -1;
    }
  }
}
