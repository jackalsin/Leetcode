package uber._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/19/2018.
 */
public final class SolutionI implements Solution {
  private static final int N = 26;
  private static final char BASE = 'a', VISITED = '#';
  private final TrieNode root = new TrieNode();

  public List<String> findWords(char[][] board, String[] words) {
    for (final String word : words) {
      insert(root, word, 0);
    }
    if (board == null || board.length == 0 || board[0].length == 0) {
      return new ArrayList<>();
    }
    final List<String> result = new ArrayList<>();
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        search(result, root, board, row, col);
      }
    }
    return result;
  }

  private void search(final List<String> result, final TrieNode root, final char[][] board,
                      final int row, final int col) {
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || root == null) {
      return;
    }

    final char chr = board[row][col];
    if (chr != VISITED) {
      board[row][col] = VISITED;
      final TrieNode next = root.next[chr - BASE];
      if (next != null && next.word != null) {
        result.add(next.word);
        next.word = null;
      }
      search(result, next, board, row - 1, col);
      search(result, next, board, row + 1, col);
      search(result, next, board, row, col - 1);
      search(result, next, board, row, col + 1);
      board[row][col] = chr;
    }

  }

  /**
   * @param root
   * @param word
   * @param i
   */
  private void insert(final TrieNode root, final String word, int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    if (root.next[chr - BASE] == null) {
      root.next[chr - BASE] = new TrieNode();
    }
    insert(root.next[chr - BASE], word, i + 1);
  }

  private static final class TrieNode {
    private final TrieNode[] next = new TrieNode[N];
    private String word;
  }
}
