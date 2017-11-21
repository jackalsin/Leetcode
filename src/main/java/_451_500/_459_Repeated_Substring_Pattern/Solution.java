package _451_500._459_Repeated_Substring_Pattern;

/**
 * @author jacka
 * @version 1.0 on 11/21/2017.
 */
public class Solution {
  public boolean repeatedSubstringPattern(String s) {
    for (int start = 1; start <= s.length() / 2; start++) {
      if (s.charAt(start) == s.charAt(0)) {
        if ((s.length() % (start)) == 0) {
          if (isValidRepeat(s, s.substring(0, start))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean isValidRepeat(String s, String substring) {
    int steps = substring.length();
    for (int end = steps; end <= s.length(); end += steps) {
      if (!s.substring(end - steps, end).equals(substring)) {
        return false;
      }
    }
    return true;
  }
}
