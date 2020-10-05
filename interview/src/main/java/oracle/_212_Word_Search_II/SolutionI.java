package oracle._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/23/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 26;
  private static final char VISITED = '#';

  public List<String> findWords(char[][] board, String[] words) {
    final List<String> result = new ArrayList<>();
    if (board == null || board.length == 0) {
      return result;
    }

    final Node root = new Node();
    for (String word : words) {
      add(root, word, 0);
    }
    final int rows = board.length, cols = board[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        search(result, board, root, row, col);
      }
    }
    return result;
  }

  private static void search(final List<String> result, final char[][] board, final Node root,
                             final int row, final int col) {
    final int rows = board.length, cols = board[0].length;
    if (root == null) {
      return;
    }
    if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] == VISITED) {
      return;
    }

    final char chr = board[row][col];
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      return;
    }
    if (root.next[chrIndex].word != null) {
      result.add(root.next[chrIndex].word);
      root.next[chrIndex].word = null;
    }
    board[row][col] = VISITED;
    search(result, board, root.next[chrIndex], row + 1, col);
    search(result, board, root.next[chrIndex], row - 1, col);
    search(result, board, root.next[chrIndex], row, col + 1);
    search(result, board, root.next[chrIndex], row, col - 1);
    board[row][col] = chr;
  }

  private static void add(final Node root, final String word, final int i) {
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
    private final Node[] next = new Node[N];
    private String word;
  }
}
