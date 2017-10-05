package _301_350._336_Palindrome_Pairs;

import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/4/2017.
 */
public interface Solution {
  /**
   * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
   *
   * Example 1:
   * Given words = ["bat", "tab", "cat"]
   * Return [[0, 1], [1, 0]]
   * The palindromes are ["battab", "tabbat"]
   * Example 2:
   * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
   * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
   * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
   * @param words
   * @return
   */
  List<List<Integer>> palindromePairs(String[] words);
}
