package google._616_Add_Bold_Tag_in_String;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
public final class TrieSolution implements Solution {
  private static final String LEFT = "<b>", RIGHT = "</b>";

  public String addBoldTag(String s, String[] dict) {
    if (s == null || s.isEmpty()) return s;
    final int n = s.length();
    final boolean[] bold = new boolean[n];
    final Trie trie = new Trie();
    for (final String word : dict) {
      trie.insert(word);
    }

    for (int start = 0; start < n; ++start) {
      final int len = trie.search(s, start);
      Arrays.fill(bold, start, start + len, true);
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      if (bold[i] && (i == 0 || !bold[i - 1])) {
        sb.append(LEFT);
      }
      sb.append(s.charAt(i));
      if (bold[i] && (i == n - 1 || !bold[i + 1])) {
        sb.append(RIGHT);
      }
    }

    return sb.toString();
  }

  private static final class Trie {
    private final Node root = new Node();

    private void insert(final String word) {
      insert(root, word, 0);
    }

    private static void insert(final Node root, final String word, final int i) {
      if (i == word.length()) {
        root.len = word.length();
        return;
      }
      final char chr = word.charAt(i);
      if (root.next[chr] == null) {
        root.next[chr] = new Node();
      }
      insert(root.next[chr], word, i + 1);
    }

    private int search(final String s, final int i) {
      return search(root, s, i);
    }

    private static int search(final Node root, final String word, final int i) {
      if (i == word.length()) {
        return root.len;
      }
      int candidate = root.len;
      final char chr = word.charAt(i);
      if (root.next[chr] != null) {
        candidate = Math.max(candidate, search(root.next[chr], word, i + 1));
      }
      return candidate;
    }

    private static final class Node {
      private final Node[] next = new Node[256];
      private int len = 0;
    }
  }
}
