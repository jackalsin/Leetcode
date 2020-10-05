package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {

  public int shortestDistance(String[] words, String word1, String word2) {
    int minDiff = Integer.MAX_VALUE, i1 = -1, i2 = -1;

    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      if (word1.equals(word)) {
        i1 = i;
        if (i2 != -1) {
          minDiff = Math.min(minDiff, Math.abs(i1 - i2));
        }
      } else if (word2.equals(word)) {
        i2 = i;
        if (i1 != -1) {
          minDiff = Math.min(minDiff, Math.abs(i1 - i2));
        }
      }
    }

    return minDiff;
  }
}
