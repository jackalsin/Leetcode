package oracle._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 12/2/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int shortestDistance(String[] words, String word1, String word2) {
    int min = Integer.MAX_VALUE;
    for (int i = -1, j = -1, k = 0; k < words.length; ++k) {
      if (word1.equals(words[k])) {
        i = k;
        if (j != -1) {
          min = Math.min(min, i - j);
        }
      } else if (word2.equals(words[k])) {
        j = k;
        if (i != -1) {
          min = Math.min(min, j - i);
        }
      }
    }
    return min;
  }
}
