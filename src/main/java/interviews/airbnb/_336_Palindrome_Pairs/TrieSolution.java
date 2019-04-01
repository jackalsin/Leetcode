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
    for (int i = 0; i < words.length; i++) {
      insert(words[i], i);
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      search(result, words[i], i);
    }
    return result;
  }

  private void search(final List<List<Integer>> result, final String word, final int indexInWords) {
    Node root = this.root;
    for (int i = 0; i < word.length(); i++) {
      final char chr = word.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.indexInWords >= 0 && indexInWords != root.indexInWords && isPalindrome(word, i, word.length() - 1)) {
        result.add(Arrays.asList(indexInWords, root.indexInWords));
      }
      if (root.next[chrIndex] == null) return;
      root = root.next[chrIndex];
    }
    // [curWord] [palindrome] [reverse cur word]
    for (int i : root.index) {
      if (indexInWords != i) {
        result.add(Arrays.asList(indexInWords, i));
      }
    }
  }

  private void insert(final String word, final int indexInWords) {
    Node root = this.root;
    for (int i = word.length() - 1; i >= 0; i--) {
      if (isPalindrome(word, 0, i)) {
        root.index.add(indexInWords);
      }
      final char chr = word.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        root.next[chrIndex] = new Node();
      }
      root = root.next[chrIndex];
    }
    root.indexInWords = indexInWords;
    root.index.add(indexInWords);
  }

  private static boolean isPalindrome(final String word, int i, int j) {
    for (; i < j; i++, j--) {
      if (word.charAt(i) != word.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private int indexInWords = -1;
    /**
     * index of words that is palindrome below
     * exclusive
     */
    private final List<Integer> index = new ArrayList<>();
  }
}
