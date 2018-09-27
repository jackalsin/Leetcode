package interviews.linkedin._245_Shortest_Word_Distance_III;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIV implements Solution {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    assert word1 != null && word2 != null;
    int i1 = -1, i2 = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      if (word1.equals(word)) {
        if (word1.equals(word2)) {
          i1 = i2;
          i2 = i;
        } else {
          i1 = i;
        }
      } else if (word2.equals(word)){
        i2 = i;
      }

      if (i1 != -1 && i2 != -1) {
        min = Math.min(min, Math.abs(i1 - i2));
      }
    }
    return min;
  }
}
