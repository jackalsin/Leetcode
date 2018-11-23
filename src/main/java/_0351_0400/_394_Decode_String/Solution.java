package _0351_0400._394_Decode_String;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class Solution {
//  private int end = 0;
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    helper(s, 0, sb);
    return sb.toString();
  }

  /**
   * Return the index ']' or
   * @param s
   * @param start
   * @param sb
   * @return
   */
  private int helper(final String s, int start, final StringBuilder sb) {
    if (start == s.length()) {
      return start;
    }
    int repeatTimes = 0;
    for (int i = start; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        StringBuilder repeatString = new StringBuilder();
        final int end = helper(s, i + 1, repeatString);
        repeatTimes = repeatTimes == 0 ? 1 : repeatTimes;
        while (repeatTimes-- > 0) {
          sb.append(repeatString.toString());
        }
        repeatTimes = 0;
        i = end;
      } else if (Character.isDigit(s.charAt(i))) {
        repeatTimes = repeatTimes * 10 + (s.charAt(i) - '0');
      } else if (s.charAt(i) == ']') {
        return i;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return s.length();
  }
}
