package interviews.linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  private static final int INVALID = -1;

  public int shortestWordDistance(String[] words, String word1, String word2) {
    if (word1.equals(word2)) {
      return shortestWordDistance(words, word1);
    } else {
      return shortestWordDistanceDiff(words, word1, word2);
    }
  }

  private int shortestWordDistanceDiff(String[] words, String word1, String word2) {
    int minDiff = Integer.MAX_VALUE, i1 = INVALID, i2 = INVALID;
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      if (word.equals(word1)) {
        i1 = i;
      } else if (word.equals(word2)) {
        i2 = i;
      }
      if (i1 != INVALID && i2 != INVALID) {
        minDiff = Math.min(minDiff, Math.abs(i2 - i1));
      }
    }
    return minDiff;
  }

  private int shortestWordDistance(String[] words, String word) {
    int minDiff = Integer.MAX_VALUE, i1 = INVALID, i2 = INVALID;

    for (int i = 0; i < words.length; i++) {
      final String w = words[i];
      if (word.equals(w)) {
        i1 = i2;
        i2 = i;
        if (i1 != INVALID) {
          minDiff = Math.min(minDiff, Math.abs(i2 - i1));
        }
      }
    }
    return minDiff;
  }
}
