package _201_250._245_Shortest_Word_Distance_III;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    if (word1.equals(word2)) {
      return shortestWordDistance(words, word1);
    } else {
      return shortestDifferentWordDistance(words, word1, word2);
    }
  }
  private int shortestDifferentWordDistance (String[] words, String word1, String word2) {
    int i1 = Integer.MIN_VALUE, i2 = Integer.MIN_VALUE, minBias = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      if(word1.equals(words[i])) {
        i1 = i;
      } else if (word2.equals(words[i])) {
        i2 = i;
      }
      if (i1 != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
        minBias = Math.min(minBias, Math.abs(i2 - i1));
      }
    }
    return minBias;
  }
  private int shortestWordDistance(String[] words, String word) {
    int prev = Integer.MIN_VALUE, minBias = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; ++i) {
      if (words[i].equals(word)) {
        if (prev != Integer.MIN_VALUE) {
          minBias = Math.min(minBias, i - prev);
        }
        prev = i;
      }
    }
    return minBias;
  }
}
