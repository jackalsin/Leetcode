package interviews.microsoft._212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final int N = 26;
  private static final char BASE = 'a';

  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public List<String> findWords(char[][] board, String[] words) {
    final List<String> result = new ArrayList<>();

    if (board == null || board.length == 0 || board[0].length == 0) {
      return result;
    }

    if (words == null || words.length == 0) {
      return result;
    }

    final Node root = new Node();
    for (String word : words) {
      insert(root, word, 0);
    }

    final int rows = board.length, cols = board[0].length;
    final boolean[][] visited = new boolean[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        search(result, board, visited, root, row, col);
      }
    }

    return result;
  }

  private void search(final List<String> result, final char[][] board, final boolean[][] visited,
                      final Node root, final int row, final int col) {
    if (root == null) {
      return;
    }
    if (root.word != null) {
      result.add(root.word);
      root.word = null;
    }
    final int rows = board.length, cols = board[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
      return;
    }
    final char chr = board[row][col];
    final int chrIndex = chr - BASE;
    visited[row][col] = true;
    search(result, board, visited, root.next[chrIndex], row + 1, col);
    search(result, board, visited, root.next[chrIndex], row - 1, col);
    search(result, board, visited, root.next[chrIndex], row, col + 1);
    search(result, board, visited, root.next[chrIndex], row, col - 1);
    visited[row][col] = false;
  }

  private void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }

    final int charIndex = word.charAt(i) - BASE;
    if (root.next[charIndex] == null) {
      root.next[charIndex] = new Node();
    }
    insert(root.next[charIndex], word, i + 1);
  }

  private static final class Node {

    private String word;
    private final Node[] next = new Node[N];
  }

}
