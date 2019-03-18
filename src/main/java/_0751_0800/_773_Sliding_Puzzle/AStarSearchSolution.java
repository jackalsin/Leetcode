package _0751_0800._773_Sliding_Puzzle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 */
public final class AStarSearchSolution implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };
  private static final String TARGET = "123450",
      TARGET_WRONG = "123540";
  private static final int ROWS = 2, COLS = 3;

  public int slidingPuzzle(int[][] board) {
    final int[] zero = getZeroIndex(board);

    final PriorityQueue<Node> pq = new PriorityQueue<>(
        new Comparator<Node>() {
          @Override
          public int compare(Node a, Node b) {
            return Integer.compare(a.heuristic + a.depth, b.heuristic + b.depth);
          }
        }
    );

    final Node start = new Node(board, zero[0], zero[1], 0);
    pq.add(start);
    final Map<String, Integer> costs = new HashMap<>();
    costs.put(start.boardStr, Integer.MAX_VALUE);
    while (!pq.isEmpty()) {
      final Node node = pq.remove();
      if (TARGET.equals(node.boardStr)) {
        return node.depth;
      }
      if (TARGET_WRONG.equals(node.boardStr)) {
        return -1;
      }
      if (node.depth + node.heuristic > costs.get(node.boardStr)) {
        continue;
      }

      for (final int[] d : DIRS) {
        final int nextRow = d[0] + node.zeroRow, nextCol = d[1] + node.zeroCol;
        if (!isValid(nextRow, nextCol)) {
          continue;
        }
        final int[][] nextBoard = new int[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
          System.arraycopy(node.board[row], 0, nextBoard[row], 0, COLS);
        }

        // Swap the board
        {
          nextBoard[node.zeroRow][node.zeroCol] = nextBoard[nextRow][nextCol];
          nextBoard[nextRow][nextCol] = 0;
        }
        final Node nextNode = new Node(nextBoard, nextRow, nextCol, node.depth + 1);
        final int curCost = nextNode.depth + nextNode.heuristic;
        if (nextNode.depth + nextNode.heuristic >= costs.getOrDefault(nextNode.boardStr, Integer.MAX_VALUE)) {
          continue;
        }
        pq.add(nextNode);
        costs.put(nextNode.boardStr, curCost);
      }
    }
    return -1;
  }

  private static boolean isValid(final int row, final int col) {
    return 0 <= row && row < ROWS && 0 <= col && col < COLS;
  }

  private static int[] getZeroIndex(final int[][] board) {
    final int[] d = new int[2];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          d[0] = i;
          d[1] = j;
          break;
        }
      }
    }
    return d;
  }

  private static final class Node {
    private final int[][] board;
    private final int zeroRow, zeroCol, depth, heuristic;
    private final String boardStr;

    private Node(final int[][] board, int zeroRow, int zeroCol, int depth) {
      this.board = board;
      this.boardStr = boardToString(board);
      this.zeroRow = zeroRow;
      this.zeroCol = zeroCol;
      this.depth = depth;
      this.heuristic = getHeuristic(board);
    }

    private static int getHeuristic(final int[][] board) {
      int heuristic = 0;
      final int rows = board.length, cols = board[0].length;
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          if (board[r][c] == 0) continue;
          final int v = (board[r][c] - 1 + rows * cols) % (rows * cols);
          // manhattan dist
          heuristic += Math.abs(r - v / cols) + Math.abs(c - v % cols);
        }
      }
      // 如果我们把A移动到B，那么B也会移动到某个地方，那么heuristic相当于是对半分
      return heuristic / 2;
    }

    private static String boardToString(final int[][] board) {
      final StringBuilder sb = new StringBuilder();
      final int rows = board.length, cols = board[0].length;
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          sb.append(board[r][c]);
        }
      }
      return sb.toString();
    }
  }
}
