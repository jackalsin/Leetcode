package interviews.airbnb.lintcode_604_The_Boggle_Game;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements MaxWordsPlacedSolution {

  private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private int rows, cols, max = 0;
  private final Node root = new Node();
  private static final char VISITED = '#';
  private final List<String> curPath = new ArrayList<>();

  public int boggleGame(char[][] board, String[] words) {
    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return 0;
    }
    this.rows = board.length;
    this.cols = board[0].length;
    for (final String w : words) {
      insert(root, w);
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        search(board, row, col, root);
      }
    }
    return max;
  }

  /**
   * @param board
   * @param startRow
   * @param startCol
   * @param root     parent node.
   */
  private void search(final char[][] board, final int startRow, final int startCol, final Node root) {
    if (!isInRange(startRow, startCol) || board[startRow][startCol] == VISITED
        || root.next[board[startRow][startCol] - 'a'] == null) {
      return;
    }
    final char chr = board[startRow][startCol];
    final int chrIndex = chr - 'a';
    board[startRow][startCol] = VISITED;
    final Node nextRoot = root.next[chrIndex];
    if (nextRoot.word != null) {
      curPath.add(nextRoot.word);
      max = Math.max(max, curPath.size());
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          search(board, r, c, this.root);
        }
      }

      board[startRow][startCol] = chr;
      curPath.remove(curPath.size() - 1);
      return; // 顶多一样多
    }
    for (final int[] d : DIRS) {
      final int nextX = d[0] + startRow, nextY = startCol + d[1];
      search(board, nextX, nextY, nextRoot);
    }
    board[startRow][startCol] = chr;
  }

  private static void insert(final Node root, final String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      final char chr = word.charAt(i);
      final int chrIndex = chr - 'a';
      if (cur.next[chrIndex] == null) {
        cur.next[chrIndex] = new Node();
      }
      cur = cur.next[chrIndex];
    }
    cur.word = word;
  }

  private boolean isInRange(final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private static final class Node {
    private final Node[] next = new Node[26];
    private String word;
  }
}
