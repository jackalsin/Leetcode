package interviews.uber._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/19/2018.
 */
public final class SolutionII implements Solution {
  private static final int N = 26;
  private static final char VISITED = 'X';

  public List<String> findWords(char[][] board, String[] words) {
    final List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }
    final Node root = new Node();
    for (String w : words) {
      insert(root, w, 0);
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        dfs(board, result, root, row, col);
      }
    }
    return result;
  }

  private void dfs(final char[][] board, final List<String> result, final Node root,
                   int row, int col) {
    if (root == null) {
      return;
    }
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == VISITED) {
      return;
    }
    final char chr = board[row][col];
    board[row][col] = VISITED;
    dfs(board, result, root.next[chr - 'a'], row - 1, col);
    dfs(board, result, root.next[chr - 'a'], row + 1, col);
    dfs(board, result, root.next[chr - 'a'], row, col - 1);
    dfs(board, result, root.next[chr - 'a'], row, col + 1);
    board[row][col] = chr;
  }

  private static void insert(final Node root, final String word, final int index) {
    if (word.length() == index) {
      root.word = word;
      return;
    }
    final char chr = word.charAt(index);
    if (root.next[chr - 'a'] == null) {
      root.next[chr - 'a'] = new Node();
    }
    insert(root.next[chr - 'a'], word, index + 1);
  }

  private static final class Node {
    private String word;
    private final Node[] next = new Node[N];
  }

}
