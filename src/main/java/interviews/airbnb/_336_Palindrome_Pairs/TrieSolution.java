package interviews.airbnb._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/3/2019.
 */
public final class TrieSolution implements Solution {
  private final List<List<Integer>> result = new ArrayList<>();
  private final Node root = new Node();

  public List<List<Integer>> palindromePairs(String[] words) {
    for (int i = 0; i < words.length; i++) {
      insert(root, i, words[i]);
    }

    for (int i = 0; i < words.length; i++) {
      search(root, i, words[i]);
    }
    return result;
  }

  private void insert(Node root, final int wordIndex, final String word) {
    assert root != null;
    for (int j = word.length() - 1; j >= 0; j--) {
      if (isPalindrome(word, 0, j)) {
        root.index.add(wordIndex);
      }
      final char chr = word.charAt(j);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        root.next[chrIndex] = new Node();
      }
      root = root.next[chrIndex];
    }
    root.index.add(wordIndex);
    root.indexInWords = wordIndex;
  }

  private void search(Node root, final int indexInWords, String word) {
    for (int i = 0; i < word.length(); i++) {
      // curWord [non-palindrome][palindrome], word in trie [non-palindrome 反过来]
      if (root.indexInWords >= 0 && isPalindrome(word, i, word.length() - 1)) {
        result.add(Arrays.asList(indexInWords, root.indexInWords));
      }

      final char chr = word.charAt(i);
      final int chrIndex = chr - 'a';
      if (root.next[chrIndex] == null) {
        root.next[chrIndex] = new Node();
      }
      root = root.next[chrIndex];
    }

    // word + [palindrome] + 之前的word 不palindrome的部分
    for (int child : root.index) {
      if (indexInWords != child) {
        result.add(Arrays.asList(indexInWords, child));
      }
    }

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
    private final Node[] next = new Node[26];
    /**
     * index in words
     */
    private int indexInWords = -1;
    private final List<Integer> index = new ArrayList<>();
  }
}
