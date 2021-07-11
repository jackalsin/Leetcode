package doordash._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/5/2021
 */
public final class SolutionI implements Solution {
  private static final int N = 9;
  private static final char DOT = '.', ONE = '1';
  private static final Set<Character> FULL = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');
  private final List<Set<Character>> allCols = List.of(
      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>()
  ), allRows = List.of(
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
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>()),
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>()),
      List.of(new HashSet<>(), new HashSet<>(), new HashSet<>())
  );

  public void solveSudoku(char[][] board) {
    for (int row = 0; row < N; ++row) {
      for (int col = 0; col < N; ++col) {
        final char chr = board[row][col];
        if (chr != DOT) {
          allRows.get(row).add(chr);
          allCols.get(col).add(chr);
          squares.get(row / 3).get(col / 3).add(chr);
        }
      }
    }
    assert solveRow(board, 0);
  }

  private boolean solveRow(final char[][] board, final int row) {
    if (row == N) return true;
    final boolean[] used = new boolean[N];
    for (final char c : board[row]) {
      if (DOT != c) used[c - ONE] = true;
    }
    return solveCol(board, row, 0, used);
  }

  private boolean solveCol(final char[][] board, final int row, final int col, final boolean[] used) {
    if (col == N) {
      return solveRow(board, row + 1);
    }
    if (board[row][col] != DOT) return solveCol(board, row, col + 1, used);
    for (int i = 0, usedLength = used.length; i < usedLength; i++) {
      final char chr = (char) (i + ONE);
      final Set<Character> rows = allRows.get(row),
          cols = allCols.get(col),
          square = squares.get(row / 3).get(col / 3);
      if (!rows.contains(chr) && !cols.contains(chr) && !square.contains(chr)) {
        rows.add(chr);
        cols.add(chr);
        square.add(chr);
        board[row][col] = chr;
        used[i] = true;
        if (solveCol(board, row, col + 1, used)) {
          return true;
        }
        used[i] = false;
        board[row][col] = DOT;
        rows.remove(chr);
        cols.remove(chr);
        square.remove(chr);
      }
    }
    return false;
  }

}
