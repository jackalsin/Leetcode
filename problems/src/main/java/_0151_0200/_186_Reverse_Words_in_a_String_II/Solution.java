package _0151_0200._186_Reverse_Words_in_a_String_II;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public void reverseWords(char[] s) {
    if (s != null && s.length != 0) {
      // reverse string
      reverseWords(s, 0, s.length - 1);
      // reverse each word
      int start = 0;
      for (int i = 0; i <= s.length; i++) {
        if(i == s.length || s[i] == ' ') {
          reverseWords(s, start, i - 1);
          start = i + 1;
        }
      }
    }
  }

  /**
   *
   * @param s
   * @param start inclusive
   * @param end   inclusive
   */
  private static void reverseWords(char[] s, int start, int end) {
    while (start < end) {
      char tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;
      start++;
      end--;
    }
  }
}
