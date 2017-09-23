package _301_350._318_Maximum_Product_of_Word_Lengths;

/**
 * @author jacka
 * @version 1.0 on 9/22/2017.
 */
public class Solution {

  public int maxProduct(String[] words) {
    final int[] wordCharSet = new int[words.length];
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      for (char c : word.toCharArray()) {
        wordCharSet[i] |= 1 << c - 'a';
      }
    }
    int max = 0;
    for (int i = 0; i < words.length - 1; ++i) {
      for (int j = i + 1; j < words.length; ++j) {
        if ((wordCharSet[i] & wordCharSet[j]) == 0) {
          int cur = words[i].length() * words[j].length();
          if (cur > max) max = cur;
        }
      }
    }
    return max;
  }

}
