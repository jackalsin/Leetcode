package _1051_1100._1065_Index_Pairs_of_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/15/2020
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();

  public int[][] indexPairs(String text, String[] words) {
    final List<int[]> result = new ArrayList<>();
    for (final String word : words) {
      add(root, word, 0);
    }
    for (int i = 0; i < text.length(); ++i) {
      search(result, root, text, i, i);
    }
    return result.toArray(new int[][]{});
  }

  private void add(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    add(root.next[chrIndex], word, i + 1);
  }

  private void search(final List<int[]> result, final Node root, final String word, final int i, final int start) {
    if (root.isWord) {
      result.add(new int[]{start, i - 1});
    }
    if (i == word.length()) {
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return;
    }
    search(result, root.next[chrIndex], word, i + 1, start);
  }

  private static class Node {
    private boolean isWord;
    private final Node[] next = new Node[26];
  }
}
