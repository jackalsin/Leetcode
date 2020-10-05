package linkedin._243_Shortest_Word_Distance;

/**
 * @author jacka
 * @version 1.0 on 7/8/2019
 */
public final class SolutionV implements Solution {
  @Override
  public int shortestDistance(String[] words, String word1, String word2) {
    if (words == null || word1 == null || word2 == null) {
      return 0;
    }
    int min = words.length, last1 = -1, last2 = -1;
    for (int i = 0; i < words.length; ++i) {
      if (words[i].equals(word1)) {
        if (last2 != -1) {
          min = Math.min(min, Math.abs(i - last2));
        }
        last1 = i;
      } else if (words[i].equals(word2)) {
        if (last1 != -1) {
          min = Math.min(min, Math.abs(i - last1));
        }
        last2 = i;
      }
    }
    return min;
  }
}
