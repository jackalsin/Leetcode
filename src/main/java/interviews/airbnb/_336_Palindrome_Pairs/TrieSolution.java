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
  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> palindromePairs(String[] words) {
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      insert(root, word, i, word.length() - 1);
    }
    for (int i = 0; i < words.length; i++) {
      search(root, words[i], i, 0);
    }
    return result;
  }

  private void search(final Node root, final String word, final int indexInWords, final int i) {
    if (i == word.length()) {
      for (int otherIndex : root.indexes) {
        if (indexInWords != otherIndex) {
          result.add(Arrays.asList(indexInWords, otherIndex));
        }
      }
      return;
    } // end of i == words.length();
    if (isPalindrome(word, i, word.length() - 1) && root.indexInWords != -1 && indexInWords != root.indexInWords) {
      result.add(Arrays.asList(indexInWords, root.indexInWords));
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return;
    }
    search(root.next[chrIndex], word, indexInWords, i + 1);
  }

  private void insert(final Node root, final String word, final int indexInWords, final int i) {
    if (i == -1) {
      root.indexInWords = indexInWords;
      root.indexes.add(indexInWords);
      return;
    }
    if (isPalindrome(word, 0, i)) {
      root.indexes.add(indexInWords);
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, indexInWords, i - 1);
  }


  private static boolean isPalindrome(final String str, int left, int right) {
    for (; left < right; left++, right--) {
      final char leftChar = str.charAt(left), rightChar = str.charAt(right);
      if (leftChar != rightChar) {
        return false;
      }
    }
    return true;
  }

  private static final class Node {
    private final Node[] next = new Node[N];
    private int indexInWords = -1;
    /**
     * below this node, the index of words is palindrome
     */
    private final List<Integer> indexes = new ArrayList<>();
  }
}
