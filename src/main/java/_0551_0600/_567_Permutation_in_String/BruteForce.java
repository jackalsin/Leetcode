package _0551_0600._567_Permutation_in_String;

/**
 * @author jacka
 * @version 1.0 on 10/30/2017.
 */
public final class BruteForce implements Solution {
  @Override
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    final char[] s1Chars = s1.toCharArray();
    return helper(s1Chars, 0, s2);
  }

  private boolean helper(char[] s1Chars, int start, String s2) {
    if (start == s1Chars.length - 1) {
      return s2.contains(new String(s1Chars));
    } else {
      for (int i = start; i < s1Chars.length; i++) {
        swap(s1Chars, start, i);
        if (helper(s1Chars, start + 1, s2)) {
          return true;
        }
        swap(s1Chars, start, i);
      }
      return false;
    }
  }

  private static void swap(char[] s1Chars, int i, int j) {
    char tmp = s1Chars[i];
    s1Chars[i] = s1Chars[j];
    s1Chars[j] = tmp;
  }
}
