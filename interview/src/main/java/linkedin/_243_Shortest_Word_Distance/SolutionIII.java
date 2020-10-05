package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIII implements Solution {

  public int shortestDistance(String[] words, String word1, String word2) {
    int minDiff = Integer.MAX_VALUE;
    for (int k = 0, i = -1, j = -1; k < words.length; ++k) {
      if (word1.equals(words[k])) {
        i = k;
      } else if (word2.equals(words[k])) {
        j = k;
      }
      if (i != -1 && j != -1) {
        minDiff = Math.min(minDiff, Math.abs(j - i));
      }
    }
    return minDiff;
  }
}
