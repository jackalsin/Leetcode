package apple._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/23/2021
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();
  private final List<String> result = new ArrayList<>();
  private static final char VISITED = '#';

  public List<String> findWords(char[][] board, String[] words) {
    if (board == null || board.length == 0) {
      return result;
    }
    for (final String word : words) {
      add(root, word, 0);
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        dfs(board, root, row, col);
      }
    }
    return result;
  }

  private void dfs(final char[][] board, final Node root, final int row, final int col) {
    if (root == null) {
      return;
    }
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
        || board[row][col] == VISITED) {
      return;
    }
    final char chr = board[row][col];
    if (board[row][col] != chr) {
      return;
    }
    board[row][col] = VISITED;
    dfs(board, root.next[chr - 'a'], row + 1, col);
    dfs(board, root.next[chr - 'a'], row - 1, col);
    dfs(board, root.next[chr - 'a'], row, col + 1);
    dfs(board, root.next[chr - 'a'], row, col - 1);
    board[row][col] = chr;
  }

  private void add(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    add(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private final Node[] next = new Node[26];

    private String word;
  }
}
