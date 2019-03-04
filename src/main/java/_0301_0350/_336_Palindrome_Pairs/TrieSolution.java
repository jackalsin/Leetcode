package _0301_0350._336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursive Trie
 * <p>
 * 134 / 134 test cases passed.
 * Status: Accepted
 * Runtime: 271 ms
 * <p>
 * ****************************
 * <p>
 * 134 / 134 test cases passed.
 * Status: Accepted
 * Runtime: 56 ms
 */
public final class TrieSolution implements Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    final List<List<Integer>> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    final TrieNode root = new TrieNode();

    for (int i = 0; i < words.length; i++) {
      insert(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(result, root, words[i], i);
    }
    return result;
  }

  private static void insert(TrieNode root, final String word, final int indexInWords) {
    for (int j = word.length() - 1; j >= 0; j--) {
      if (isPalindrome(word, 0, j)) {
        root.list.add(indexInWords);
      }
      final char chr = word.charAt(j);
      final int charIndex = chr - 'a';
      if (root.next[charIndex] == null) {
        root.next[charIndex] = new TrieNode();
      }
      root = root.next[charIndex];
    }
    root.list.add(indexInWords); // 剩下的是empty string
    root.index = indexInWords;
  }

  private void search(final List<List<Integer>> result, TrieNode root, final String word, final int indexInWords) {
    for (int i = 0; i < word.length(); i++) {
      // curWord [non-palindrome][palindrome], word in trie [non-palindrome 反过来]
      if (root.index >= 0 && root.index != indexInWords && isPalindrome(word, i, word.length() - 1)) {
        result.add(Arrays.asList(indexInWords, root.index));
      }

      final char chr = word.charAt(i);
      final int charIndex = chr - 'a';
      if (root.next[charIndex] == null) {
        return;
      }

      root = root.next[charIndex];
    }
    // word + [palindrome] + 之前的word 不palindrome的部分
    for (int child : root.list) {
      if (child != indexInWords) {
        result.add(Arrays.asList(indexInWords, child));
      }
    }
  }

  private void search(final List<List<Integer>> result, final TrieNode root, final String word, int i,
                      final int indexInWords) {
    if (i == word.length()) {
      for (int child : root.list) {
        if (child != indexInWords) {
          result.add(Arrays.asList(indexInWords, child));
        }
      }
      return;
    }

    if (root.index >= 0 && root.index != indexInWords && isPalindrome(word, i, word.length() - 1)) {
      result.add(Arrays.asList(indexInWords, root.index));
    }

    final char chr = word.charAt(i);
    final int charIndex = chr - 'a';
    if (root.next[charIndex] == null) {
      return;
    }
    search(result, root.next[charIndex], word, i + 1, indexInWords);
  }

  private static void insert(final TrieNode root, final String word, final int wordIndex, final int i) {
    if (wordIndex == -1) {
      root.index = i;
      root.list.add(i);
      return;
    }
    final char chr = word.charAt(wordIndex);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }
    // if word[0, ... , wordIndex] is palindrome
    if (isPalindrome(word, 0, wordIndex)) {
      root.list.add(i);
    }

    insert(root.next[chrIndex], word, wordIndex - 1, i);
  }

  private static boolean isPalindrome(String word, int left, int right) {
    for (; left < right; left++, right--) {
      if (word.charAt(left) != word.charAt(right)) {
        return false;
      }
    }
    return true;
  }

  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[26];
    /**
     * The index in the words list; otherwise, -1;
     */
    private int index = -1;
    /**
     * 含此节点往下是回文词的index，不含此节点
     */
    private final List<Integer> list = new ArrayList<>();

  }
}
