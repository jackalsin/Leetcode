package interviews.linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIV implements Solution {

  public int shortestDistance(String[] words, String word1, String word2) {
    int minDiff = words.length - 1;
    for (int i = -1, j = -1, k = 0; k < words.length; ++k) {
      final String word = words[k];
      if (word1.equals(word)) {
        i = k;
        if (j != -1) {
          minDiff = Math.min(minDiff, Math.abs(i - j));
        }
      } else if (word2.equals(word)) {
        j = k;
        if (i != -1) {
          minDiff = Math.min(minDiff, Math.abs(i - j));
        }
      }
    }
    return minDiff;
  }
}
