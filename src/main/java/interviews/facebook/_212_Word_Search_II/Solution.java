package interviews.facebook._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final char BASE = 'a';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public List<String> findWords(char[][] board, String[] words) {
    final TrieNode root = new TrieNode();
    for (String word : words) {
      insert(root, word, 0);
    }
    final List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }
    final int rows = board.length, cols = board[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        result.addAll(search(root, board, row, col));

      }
    }
    return result;
  }

  /**
   * Find
   *
   * @param root
   * @param row
   * @param col
   * @return
   */
  private static List<String> search(final TrieNode root, final char[][] board, final int row, final int col) {
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      return new ArrayList<>();
    }
    final char chr = board[row][col];
    if (root.next[chr - BASE] == null) {
      return new ArrayList<>();
    }

    return new ArrayList<>();
  }

  private static void insert(final TrieNode root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    if (root.next[chr - BASE] == null) {
      root.next[chr - BASE] = new TrieNode();
    }
    insert(root, word, i + 1);
  }

  private static final class TrieNode {
    private String word;
    private final TrieNode[] next = new TrieNode[26];
  }
}
