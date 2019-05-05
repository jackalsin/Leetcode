package interviews.airbnb._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
public final class TrieSolution implements Solution {
  private static final int N = 26;
  private final Node root = new Node();

  public List<List<Integer>> palindromePairs(String[] words) {
    final List<List<Integer>> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      insert(root, word, word.length() - 1, i);
    }

    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      search(result, root, word, i, 0);
    }
    return result;
  }

  private void search(final List<List<Integer>> result, final Node root, final String word, final int indexInWords, final int i) {
    if (i == word.length()) {
      // word + palindrome + current path
      for (int c : root.indexes) {
        if (indexInWords != c) {
          result.add(Arrays.asList(indexInWords, c));
        }
      }
      return;
    }
    // current path + palindrome + root.wordIndex
    if (root.wordIndex != indexInWords && root.wordIndex != -1 && isPalindrome(word, i, word.length() - 1)) {
      result.add(Arrays.asList(indexInWords, root.wordIndex));
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return;
    }
    search(result, root.next[chrIndex], word, indexInWords, i + 1);
  }

  private void insert(final Node root, final String word, final int i, final int indexInWords) {
    if (i == -1) {
      root.wordIndex = indexInWords;
      root.indexes.add(indexInWords);
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }

    if (isPalindrome(word, 0, i)) {
      root.indexes.add(indexInWords);
    }
    insert(root.next[chrIndex], word, i - 1, indexInWords);
  }

  /**
   * @param word
   * @param i    inclusive
   * @param j    inclusive
   * @return
   */
  private static boolean isPalindrome(final String word, final int i, final int j) {
    for (int left = i, right = j; left < right; left++, right--) {
      if (word.charAt(left) != word.charAt(right)) {
        return false;
      }
    }
    return true;
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    /**
     * index of words
     */
    private List<Integer> indexes = new ArrayList<>();

    private int wordIndex = -1;
  }
}
