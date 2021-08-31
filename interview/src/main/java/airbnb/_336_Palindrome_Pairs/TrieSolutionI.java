package airbnb._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/30/2021
 */
public final class TrieSolutionI implements Solution {
  private final Node root = new Node();

  public List<List<Integer>> palindromePairs(String[] words) {
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      insert(root, word, word.length() - 1, i);
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length; ++i) {
      search(result, root, words[i], 0, i);
    }
    return result;
  }

  private static void search(final List<List<Integer>> result, final Node root,
                             final String word, final int i,
                             final int indexInWords) {
    if (i == word.length()) {
      for (int index : root.index) {
        if (indexInWords != index) {
          result.add(List.of(indexInWords, index));
        }
      }
      return;
    }
    if (root.indexInWords != -1 && isPalindrome(word, i, word.length() - 1)) {
      result.add(List.of(indexInWords, root.indexInWords));
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) return;
    search(result, root.next[chrIndex], word, i + 1, indexInWords);
  }

  private static void insert(final Node root, final String word,
                             final int i, final int index) {
    if (i == -1) {
      root.indexInWords = index;
      root.index.add(index);
      return;
    }
    if (isPalindrome(word, 0, i)) {
      root.index.add(index);
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i - 1, index);
  }

  private static boolean isPalindrome(final String word, int i, int j) {
    for (; i < j; ++i, --j) {
      if (word.charAt(i) != word.charAt(j)) return false;
    }
    return true;
  }

  private static final class Node {
    private final Node[] next = new Node[26];
    private int indexInWords = -1;
    /**
     * indexInWords that are palindrome this char
     */
    private final List<Integer> index = new ArrayList<>();
  }
}
