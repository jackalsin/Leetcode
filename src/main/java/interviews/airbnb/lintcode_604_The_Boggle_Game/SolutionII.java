package interviews.airbnb.lintcode_604_The_Boggle_Game;

public final class SolutionII implements OnePathSolution {
  private final Node root = new Node();
  private static final char VISITED = '#';
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  @Override
  public int boggleGame(char[][] board, String[] words) {
    if (board == null) {
      throw new NullPointerException();
    }
    if (words == null) {
      throw new NullPointerException();
    }
    if (words.length == 0 || board.length == 0 || board[0].length == 0) {
      return 0;
    }
    for (String word : words) {
      insert(root, word, 0);
    }

    final int rows = board.length, cols = board[0].length;
    int maxLength = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        final int curLen = dfs(board, root, row, col);
        maxLength = Math.max(curLen, maxLength);
      }
    }
    return maxLength;
  }

  private int dfs(final char[][] board, final Node root, final int row, final int col) {
    if (root == null) {
      return 0;
    }
    int curCount = 0;
    if (root.word != null) {
      curCount = 1 + dfs(board, this.root, row, col);
    }
    final int rows = board.length, cols = board[0].length;
    if (!isInRange(rows, cols, row, col)) {
      return curCount; // needs return previous valid count
    }
    final char chr = board[row][col];
    if (chr == VISITED) {
      return curCount; // needs return previous valid count
    }
    final int chrIndex = chr - 'a';
    board[row][col] = VISITED;
    final int left = dfs(board, root.next[chrIndex], row, col - 1),
        right = dfs(board, root.next[chrIndex], row, col + 1),
        bottom = dfs(board, root.next[chrIndex], row + 1, col),
        top = dfs(board, root.next[chrIndex], row - 1, col);

    curCount = max(curCount,
        left, right, bottom, top
    );
    board[row][col] = chr;
    return curCount;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(a, c);
    }
    return a;
  }

  private static boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= col && col < cols && 0 <= row && row < rows;
  }

  private void insert(final Node root, final String word, final int i) {
    if (i == word.length()) {
      root.word = word;
      return;
    }

    final char chr = word.charAt(i);
    final int chrIndex = chr - 'a';
    if (root.next[chrIndex] == null) {
      root.next[chrIndex] = new Node();
    }
    insert(root.next[chrIndex], word, i + 1);
  }

  private static final class Node {
    private String word;
    private final Node[] next = new Node[26];
  }
}
