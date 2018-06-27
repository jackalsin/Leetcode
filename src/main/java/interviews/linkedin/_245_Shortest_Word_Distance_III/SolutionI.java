package interviews.linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    long minDistance = Integer.MAX_VALUE, i1 = minDistance, i2 = -minDistance;
    for (int i = 0; i < words.length; ++i) {
      if (word1.equals(words[i])) {
        i1 = i;
      }
      if (word2.equals(words[i])) {
        if (i1 == i) {
          i1 = i2;
        }
        i2 = i;
      }
      minDistance = Math.min(minDistance, Math.abs(i1 - i2));
    }
    return (int) minDistance;
  }
}
