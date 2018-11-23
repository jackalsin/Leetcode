package _0451_0500._472_Concatenated_Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class Solution {

  /**
   * 44 / 44 test cases passed.
   * Status: Accepted
   * Runtime: 104 ms
   *
   * @param words
   * @return
   */
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });
    final TrieNode root = new TrieNode();
    final List<String> result = new ArrayList<>();
    for (final String word : words) {
      if (word.isEmpty()) {
        continue;
      }
//      System.out.println(word);
      if (canConcat(root, root, word, 0)) {
        result.add(word);
      }
      insert(root, word, 0);
    }
    return result;
  }

  private static boolean canConcat(final TrieNode originalRoot, final TrieNode root, String word, final int index) {
    assert root != null;
    if (index == word.length()) {
      return root.word != null;
    }
    // search
    if (root.word != null) {
      if (canConcat(originalRoot, originalRoot, word, index)) {
        return true;
      }
    }
    final char chr = word.charAt(index);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return false;
    }
    return canConcat(originalRoot, root.next[chrIndex], word, index + 1);
  }

  private static void insert(final TrieNode root, final String word, final int index) {
    if (index == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(index);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new TrieNode();
    }
    insert(root.next[chrIndex], word, index + 1);
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[26];
  }
}
