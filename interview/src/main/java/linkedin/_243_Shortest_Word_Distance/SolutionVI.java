package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public int shortestDistance(String[] words, String word1, String word2) {
    assert !word1.equals(word2);
    int index1 = -1, index2 = -1, min = words.length;
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      if (word1.equals(word)) {
        index1 = i;
        if (index2 != -1) {
          min = Math.min(min, Math.abs(index1 - index2));
        }
      } else if (word2.equals(word)) {
        index2 = i;
        if (index1 != -1) {
          min = Math.min(min, Math.abs(index1 - index2));
        }
      }
    }
    return min;
  }
}
