package _601_650._648_Replace_Words;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/5/2018.
 */
public class Solution {
  private final TrieNode root = new TrieNode();
  private static final char A = 'a';

  public String replaceWords(List<String> dict, String sentence) {
    for (String word : dict) {
      insert(root, word, 0);
    }
    final String[] words = sentence.split(" ");
    StringBuilder sb = new StringBuilder();
    for (final String word : words) {
      String shortest = findShortest(root, word, 0);
      if (shortest == null) {
        shortest = word;
      }
      sb.append(" ").append(shortest);
    }
    return sb.substring(1);
  }

  private String findShortest(TrieNode root, String word, int i) {
    if (root == null) {
      return null;
    }
    if (root.word != null) {
      return root.word;
    }
    if (i >= word.length()) {
      return null;
    }
    final char chr = word.charAt(i);
    return findShortest(root.next[chr - A], word, i + 1);
  }

  private void insert(TrieNode root, String word, int index) {
    if (index == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(index);
    if (root.next[chr - A] == null) {
      root.next[chr - A] = new TrieNode();
    }

    insert(root.next[chr - A], word, index + 1);
  }

  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[26];
    private String word;
  }
}
