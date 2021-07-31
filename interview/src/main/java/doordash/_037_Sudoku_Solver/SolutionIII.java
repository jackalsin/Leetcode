package doordash._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionIII implements Solution {
  private static final int N = 9;
  private static final char DOT = '.';
  private final List<Set<Character>> rows = List.of(
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
  private final List<List<Set<Character>>> squares = List.of(
      List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      ),
      List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      ),
      List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      )
  );

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        final char chr = board[i][j];
        if (chr == DOT) continue;
        rows.get(i).add(chr);
        cols.get(j).add(chr);
        squares.get(i / 3).get(j / 3).add(chr);
      }
    }
    solveRow(board, 0);
  }

  private boolean solveRow(final char[][] board, final int row) {
    if (row == N) return true;
    return solveCol(board, row, 0);
  }

  private boolean solveCol(final char[][] board, final int row, final int col) {
    if (col == N) return solveRow(board, row + 1);
    final char chr = board[row][col];
    if (chr != DOT) return solveCol(board, row, col + 1);
    final Set<Character> rows = this.rows.get(row), cols = this.cols.get(col),
        squares = this.squares.get(row / 3).get(col / 3);
    for (int i = 0; i < N; ++i) {
      final char val = (char) ('1' + i);
      if (rows.contains(val) || cols.contains(val) || squares.contains(val)) {
        continue;
      }
      rows.add(val);
      cols.add(val);
      squares.add(val);
      board[row][col] = val;
      if (solveCol(board, row, col + 1)) return true;
      board[row][col] = DOT;
      rows.remove(val);
      cols.remove(val);
      squares.remove(val);
    }
    return false;
  }
}


