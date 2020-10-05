package airbnb._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
public final class MapSolution implements Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    final Map<String, Integer> wordToIndex = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      wordToIndex.put(words[i], i);
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      for (int j = 0; j <= word.length(); j++) {
        final String left = word.substring(0, j), right = word.substring(j);
        if (isPalindrome(left)) {
          final String leftTarget = new StringBuilder().append(right).reverse().toString();
          if (wordToIndex.containsKey(leftTarget)) {
            final int otherIndex = wordToIndex.get(leftTarget);
            if (i != otherIndex) {
              result.add(getIndexList(otherIndex, i));
            }
          }
        }
        if (right.length() != 0 && isPalindrome(right)) {
          final String rightTarget = new StringBuilder().append(left).reverse().toString();
          if (wordToIndex.containsKey(rightTarget)) {
            final int otherIndex = wordToIndex.get(rightTarget);
            if (i != otherIndex) {
              result.add(getIndexList(i, otherIndex));
            }
          }
        }
      }
    }
    return result;
  }

  private static boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
      final char leftChar = s.charAt(left++), rightChar = s.charAt(right--);
      if (leftChar != rightChar) {
        return false;
      }
    }
    return true;
  }

  private static List<Integer> getIndexList(int i, int j) {
    final List<Integer> res = new ArrayList<>();
    res.add(i);
    res.add(j);
    return res;
  }
}
