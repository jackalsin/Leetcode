package linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 8/6/2019
 */
public final class SolutionV implements Solution {
  @Override
  public int shortestWordDistance(String[] words, String word1, String word2) {
    if (words == null || word1 == null || word2 == null) {
      return 0;
    }
    if (word1.equals(word2)) {
      return same(words, word1, word2);
    }
    return diff(words, word1, word2);
  }

  private static int diff(final String[] words, final String word1, final String word2) {
    int res = Integer.MAX_VALUE;
    Integer j = null, k = null;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        j = i;
        if (k != null) {
          res = Math.min(res, Math.abs(j - k));
        }
      } else if (word2.equals(words[i])) {
        k = i;
        if (j != null) {
          res = Math.min(res, Math.abs(j - k));
        }
      }
    }
    return res;
  }

  private static int same(final String[] words, final String word1, final String word2) {
    assert word1.equals(word2);
    int res = Integer.MAX_VALUE;
    Integer j = null, k = null;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        k = j;
        j = i;
        if (k != null) {
          res = Math.min(res, j - k);
        }
      }
    }
    return res;
  }
}
