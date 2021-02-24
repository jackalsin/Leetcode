package apple._212_Word_Search_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/23/2021
 */
public final class SolutionI implements Solution {
  private final Node root = new Node();
  private final List<String> result = new ArrayList<>();
  private static final char VISITED = '#';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

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
        dfs(board, root, row, col, new StringBuilder());
      }
    }
    return result;
  }

  private void dfs(final char[][] board, final Node root, final int row, final int col,
                   final StringBuilder sb) {
    if (root == null) {
      return;
    }
    if (root.isWord) {
      result.add(sb.toString());
      root.isWord = false;
    }
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == VISITED) {
      return;
    }
    final char chr = board[row][col];
    sb.append(chr);
    final Node next = root.next.get(chr);
    if (next == null) {
      return;
    }
    board[row][col] = VISITED;
    final int len = sb.length();
    for (final int[] d : DIRS) {
      dfs(board, next, row + d[0], col + d[1], sb);
      sb.setLength(len);
    }
    if (next.next.isEmpty()) {
      root.next.remove(chr);
    }
    board[row][col] = chr;
  }

  private void add(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.isWord = true;
      return;
    }
    final char chr = word.charAt(i);
    final Node next = root.next.computeIfAbsent(chr, k -> new Node());
    add(next, word, i + 1);
  }

  private static final class Node {
    private final Map<Character, Node> next = new HashMap<>();
    private boolean isWord;
  }
}
