package linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIII implements Solution {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    int minDiff = Integer.MAX_VALUE;
    for (int k = 0, i = -1, j = -1; k < words.length; ++k) {
      final String word = words[k];
      if (word1.equals(word)) {
        if (word2.equals(word1)) {
          i = j;
          j = k;
        } else {
          i = k;
        }
      } else if (word2.equals(word)) {
        j = k;
      }
      if (i != -1 && j != -1) {
        minDiff = Math.min(minDiff, Math.abs(j - i));
      }
    }
    return minDiff;
  }
}
