package interviews.uber._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapSolution implements Solution {

  public List<List<Integer>> palindromePairs(String[] words) {
    final List<List<Integer>> result = new ArrayList<>();
    final Map<String, Integer> wordToIndex = new HashMap<>();
    // inverted index
    for (int i = 0; i < words.length; i++) {
      wordToIndex.put(words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      for (int j = 0; j <= word.length(); j++) {
        final String prev = word.substring(0, j), mid = word.substring(j);
        if (isPalindrome(prev)) {
          final String toMatch = new StringBuilder(mid).reverse().toString();
          final Integer toMatchIndex = wordToIndex.get(toMatch);
          if (toMatchIndex != null && toMatchIndex != i) {
            result.add(Arrays.asList(wordToIndex.get(toMatch), i));
          }
        }

        if (isPalindrome(mid)&& mid.length() != 0) {
          final String toMatch = new StringBuilder(prev).reverse().toString();
          final Integer toMatchIndex = wordToIndex.get(toMatch);
          if (toMatchIndex != null && toMatchIndex != i ) {
            result.add(Arrays.asList(i, wordToIndex.get(toMatch)));
          }
        }

      }
    }

    return result;
  }

  private static boolean isPalindrome(final String word) {
    for (int left = 0, right = word.length() - 1; left < right; left++, right--) {
      if (word.charAt(left) != word.charAt(right)) {
        return false;
      }
    }
    return true;
  }

}
