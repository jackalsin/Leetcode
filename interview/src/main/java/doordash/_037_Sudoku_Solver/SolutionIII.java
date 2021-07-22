package doordash._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionIII implements Solution {
  private static final int N = 9;
  private static final char DOT = '.';
  private final List<Set<Integer>> rows = List.of(
      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>()
  ), cols = List.of(
      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>()
  );
  private final List<List<Set<Integer>>> squares = List.of(
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>()),
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>()),
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>())
  );

  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (board[i][j] == DOT) continue;
        final int val = board[i][j] - '0';
        rows.get(i).add(val);
        cols.get(j).add(val);
        squares.get(i / 3).get(j / 3).add(val);
      }
    }
    solveRow(board, 0);
  }

  private boolean solveRow(final char[][] board, final int row) {
    if (row == N) return true;
    return solveCol(board, row, 0);
  }

  private boolean solveCol(final char[][] board, final int row, final int col) {
    if (col == N) {
      return solveRow(board, row + 1);
    }
    if (board[row][col] != DOT) return solveCol(board, row, col + 1);
    final Set<Integer> rowSet = rows.get(row),
        colSet = cols.get(col),
        squareSet = squares.get(row / 3).get(col / 3);
    for (int i = 1; i <= N; ++i) {
      if (rowSet.contains(i) || colSet.contains(i) || squareSet.contains(i)) continue;
      rowSet.add(i);
      colSet.add(i);
      squareSet.add(i);
      board[row][col] = (char) ('0' + i);
      if (solveCol(board, row, col + 1)) return true;
      board[row][col] = DOT;
      squareSet.remove(i);
      colSet.remove(i);
      rowSet.remove(i);
    }
    return false;
  }
}
