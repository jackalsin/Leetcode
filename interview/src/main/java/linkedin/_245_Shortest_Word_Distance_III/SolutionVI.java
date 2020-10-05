package linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 9/1/2019
 */
public final class SolutionVI implements Solution {
  public int shortestWordDistance(final String[] words, final String word1,
                                  final String word2) {
    if (words == null || word1 == null || word2 == null) {
      return 0;
    }
    if (word1.equals(word2)) {
      return same(words, word1);
    }
    return diff(words, word1, word2);
  }

  private static int diff(final String[] words, final String word1, final String word2) {
    int min = Integer.MAX_VALUE;
    Integer prev1 = null, prev2 = null;
    for (int i = 0; i < words.length; ++i) {
      if (word1.equals(words[i])) {
        if (prev2 != null) {
          min = Math.min(min, i - prev2);
        }
        prev1 = i;
      } else if (word2.equals(words[i])) {
        if (prev1 != null) {
          min = Math.min(min, i - prev1);
        }
        prev2 = i;
      }
    }
    return min;
  }

  private static int same(final String[] words, final String target) {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    for (int i = 0; i < words.length; ++i) {
      if (target.equals(words[i])) {
        if (prev != null) {
          min = Math.min(min, i - prev);
        }
        prev = i;
      }
    }
    return min;
  }
}
