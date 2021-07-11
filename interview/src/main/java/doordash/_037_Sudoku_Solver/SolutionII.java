package doordash._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public final class SolutionII implements Solution {
  private static final int N = 9;

  private final List<Set<Character>> rowSets = List.of(
      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>()
  ), colSets = List.of(
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
  private static final char DOT = '.';

  public void solveSudoku(char[][] board) {
    for (int row = 0; row < N; ++row) {
      for (int col = 0; col < N; ++col) {
        final char chr = board[row][col];
        if (chr == DOT) continue;
        rowSets.get(row).add(chr);
        colSets.get(col).add(chr);
        squares.get(row / 3).get(col / 3).add(chr);
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
    if (board[row][col] != DOT) return solveCol(board, row, col + 1);
    final Set<Character> rowSet = rowSets.get(row),
        colSet = colSets.get(col),
        square = squares.get(row / 3).get(col / 3);
    for (int i = 0; i < N; ++i) {
      final char chr = (char) ('1' + i);
      if (rowSet.contains(chr) || colSet.contains(chr) || square.contains(chr)) continue;
      rowSet.add(chr);
      colSet.add(chr);
      square.add(chr);
      board[row][col] = chr;
      if (solveCol(board, row, col + 1)) return true;
      board[row][col] = DOT;
      rowSet.remove(chr);
      colSet.remove(chr);
      square.remove(chr);
    }
    return false;
  }
}
