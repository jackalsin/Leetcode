package _201_250._243_Shortest_Word_Distance;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class Solution {
  /**
   * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
   * Given word1 = “coding”, word2 = “practice”, return 3.
   * Given word1 = "makes", word2 = "coding", return 1.
   * @param words
   * @param word1
   * @param word2
   * @return
   */
  public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = Integer.MIN_VALUE;
    int i2 = Integer.MIN_VALUE;
    int minBias = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      if (words[i].equals(word1)) {
        i1 = i;
      } else if (words[i].equals(word2)) {
        i2 = i;
      }
      if (i1 != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
        minBias = Math.min(minBias, Math.abs(i2 - i1));
      }
    }
    return minBias;
  }
}
