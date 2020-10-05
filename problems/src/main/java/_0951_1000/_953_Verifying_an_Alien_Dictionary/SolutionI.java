package _0951_1000._953_Verifying_an_Alien_Dictionary;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
public final class SolutionI implements Solution {
  private final int[] map = new int[26];
  private static final char A = 'a';

  public boolean isAlienSorted(String[] words, String order) {
    final char[] orders = order.toCharArray();
    for (int i = 0; i < 26; ++i) {
      map[orders[i] - A] = i;
    }
    for (int i = 1; i < words.length; ++i) {
      if (compare(words[i - 1], words[i]) > 0) {
        return false;
      }
    }
    return true;
  }

  private int compare(final String word1, final String word2) {
    final int minLen = Math.min(word1.length(), word2.length());
    for (int i = 0; i < minLen; ++i) {
      final char leftChar = word1.charAt(i), rightChar = word2.charAt(i);
      final int cmp = Integer.compare(map[leftChar - A], map[rightChar - A]);
      if (cmp != 0) {
        return cmp;
      }
    }
    return Integer.compare(word1.length(), word2.length());
  }
}
