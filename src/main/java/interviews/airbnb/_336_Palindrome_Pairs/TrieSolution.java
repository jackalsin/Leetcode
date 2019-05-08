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
      String word = words[i];
      insert(root, word, i, word.length() - 1);
    }
    for (int i = 0; i < words.length; i++) {
      search(result, root, words[i], i, 0);
    }
    return result;
  }

  private static void search(final List<List<Integer>> result, final Node root, final String word, final int indexInWords, int i) {
    if (i == word.length()) {
      // current word, palindrome, curPath
      for (int index : root.index) {
        if (index != indexInWords) {
          result.add(Arrays.asList(indexInWords, index));
        }
      }
      return;
    } // end of i == word.length();

    // curPath, palindrome, word ending here
    if (root.indexInWords != -1 && indexInWords != root.indexInWords && isPalindrome(word, i, word.length() - 1)) {
      result.add(Arrays.asList(indexInWords, root.indexInWords));
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return;
    }
    search(result, root.next[chrIndex], word, indexInWords, i + 1);
  }

  private static void insert(final Node root, final String word, int indexInWords, final int i) {
    if (i == -1) {
      root.indexInWords = indexInWords;
      root.index.add(indexInWords);
      return;
    }
    if (isPalindrome(word, 0, i)) {
      root.index.add(indexInWords);
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, indexInWords, i - 1);
  }

  private static boolean isPalindrome(final String word, final int left, final int right) {
    for (int i = left, j = right; i < j; i++, j--) {
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
     * index of words that after this char (exclusive) are
     */
    private final List<Integer> index = new ArrayList<>();
  }
}
