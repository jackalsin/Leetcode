package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {

  public int shortestDistance(String[] words, String word1, String word2) {
    int word1Index = Integer.MIN_VALUE, word2Index = Integer.MIN_VALUE, minDistance = Integer
        .MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      if (word1.equals(words[i])) {
        word1Index = i;
        if (word2Index != Integer.MIN_VALUE) {
          minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
        }
      } else if (word2.equals(words[i])) {
        word2Index = i;
        if (word1Index != Integer.MIN_VALUE) {
          minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index));
        }
      }
    }
    return minDistance;
  }
}
