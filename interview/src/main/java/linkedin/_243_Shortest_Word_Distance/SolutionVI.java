package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = -1, i2 = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      if (word1.equals(word)) {
        i1 = i;
      } else if (word2.equals(word)) {
        i2 = i;
      }
      if (i1 != -1 && i2 != -1) {
        min = Math.min(min, Math.abs(i1 - i2));
      }
    }
    assert i1 != -1 && i2 != -1;
    return min;
  }
}
