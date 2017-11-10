package _351_400._389_Find_the_Difference;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class Solution {
  public char findTheDifference(String s, String t) {
//    return arrayOperation(s, t);
    return bitOperation(s, t);
  }

  private char bitOperation(String s, String t) {
    char c = 0;
    for (char chr : s.toCharArray()) {
      c ^= chr;
    }

    for (char chr : t.toCharArray()) {
      c ^= chr;
    }
    return c;
  }

  private char arrayOperation(final String s, final String t) {
    final int[] counts = new int[26];
    for (char chr : s.toCharArray()) {
      counts[chr - 'a']++;
    }

    for (char chr : t.toCharArray()) {
      if (counts[chr - 'a']-- == 0) {
        return chr;
      }
    }
    throw new IllegalStateException(
        String.format("f = \"%s\" contains all chars in s = \"%s\" ", t, s ));
  }
}
