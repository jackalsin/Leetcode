package airbnb._773_Sliding_Puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public final class MNSolution {
  private int rows, cols;
  private String target;
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public int slidingPuzzle(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return 0;
    }

    rows = board.length;
    cols = board[0].length;
    // generate target
    generateTarget();
    final Map<String, Integer> cost = new HashMap<>();
    final PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.h + x.cost, y.cost + y.h));
    final Node startNode = new Node(board, 0);
    if (startNode.str.equals(target)) {
      return 0;
    }
    pq.add(startNode);
    while (!pq.isEmpty()) {
      final Node toRemove = pq.remove();
      if (toRemove.cost >= cost.getOrDefault(toRemove.str, Integer.MAX_VALUE)) {
        continue;
      }
      cost.put(toRemove.str, toRemove.cost);
      for (final int[] d : DIRS) {
        final int nextRow = toRemove.zeroRow + d[0],
            nextCol = toRemove.zeroCol + d[1];
        if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
          continue;
        }
        swap(toRemove.board, new int[]{toRemove.zeroRow, toRemove.zeroCol}, new int[]{nextRow, nextCol});
        final Node nextNode = new Node(toRemove.board, toRemove.cost + 1);
        if (nextNode.str.equals(target)) {
          return nextNode.cost;
        }

        pq.add(nextNode);
        swap(toRemove.board, new int[]{toRemove.zeroRow, toRemove.zeroCol}, new int[]{nextRow, nextCol});
      }
    }
    return -1;
  }

  private static void swap(final int[][] board, final int[] src, final int[] dst) {
    final int tmp = board[src[0]][src[1]];
    board[src[0]][src[1]] = board[dst[0]][dst[1]];
    board[dst[0]][dst[1]] = tmp;
  }

  /**
   * Generate board 123456780
   */
  private void generateTarget() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        sb.append(i * cols + j + 1);
      }
    }
    sb.setCharAt(sb.length() - 1, '0');
    target = sb.toString();
  }

  private static final class Node {
    private final int[][] board;
    private final int h, cost;
    private final String str;
    private int zeroRow, zeroCol;

    private Node(int[][] board, int cost) {
      final int rows = board.length, cols = board[0].length;
      this.board = new int[rows][cols];
      for (int i = 0; i < board.length; i++) {
        System.arraycopy(board[i], 0, this.board[i], 0, cols);
      }
      this.cost = cost;
      str = toString();
      long sum = getDiffSum();
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (board[i][j] != 0) {
            final int rightRow = (board[i][j] - 1) / cols, rightCol = (board[i][j] - 1) % cols;
            sum += Math.abs(i - rightRow) + Math.abs(j - rightCol);
          } else {
            zeroRow = i;
            zeroCol = j;
            sum += Math.abs(i - (rows - 1)) + Math.abs(j - (cols - 1));
          }
        }
      }
      h = (int) (sum / 2);
    }

    private long getDiffSum() {
      long sum = 0;
      final int rows = board.length, cols = board[0].length;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (board[i][j] != 0) {
            final int rightRow = (board[i][j] - 1) / cols, rightCol = (board[i][j] - 1) % cols;
            sum += Math.abs(i - rightRow) + Math.abs(j - rightCol);
          } else {
            zeroRow = i;
            zeroCol = j;
            sum += Math.abs(i - (rows - 1)) + Math.abs(j - (cols - 1));
          }
        }
      }
      return sum;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder();
      for (int[] b : board) {
        for (int c : b) {
          sb.append(c);
        }
      }
      return sb.toString();
    }

  }

}

