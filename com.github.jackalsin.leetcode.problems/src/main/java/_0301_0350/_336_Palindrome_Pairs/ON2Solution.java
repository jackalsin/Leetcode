package _0301_0350._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/4/2017.
 */
public final class ON2Solution implements Solution {

  /**
   * O(N^2) Solution
   * @param words
   * @return
   */
  @Override
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length - 1; ++i) {
      for (int j = i + 1; j < words.length; ++j) {
        if (isPalindrome(words[i], words[j])) {
          result.add(Arrays.asList(i, j));
        }
        if (isPalindrome(words[j], words[i])) {
          result.add(Arrays.asList(j, i));
        }
      }
    }
    return result;
  }

  private boolean isPalindrome(String word1, String word2) {
    int i = 0, j = word1.length() + word2.length() - 1;
    while (i < j) {
      char left = i < word1.length() ? word1.charAt(i) : word2.charAt(i - word1.length());
      char right = j >= word1.length() ? word2.charAt(j - word1.length()) : word1.charAt(j);
      if (left != right) {
        return false;
      }
      ++i;
      --j;
    }
    return true;
  }
}
