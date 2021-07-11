package doordash._036_Valid_Sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public final class SolutionII implements Solution {
  private final List<Set<Character>> rowSet = List.of(
      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>(),

      new HashSet<>(),
      new HashSet<>(),
      new HashSet<>()
  ), colSet = List.of(
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
      ), List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      ), List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      )
  );
  private static final int N = 9;

  public boolean isValidSudoku(char[][] board) {
    for (int row = 0; row < N; ++row) {
      for (int col = 0; col < N; ++col) {
        final char chr = board[row][col];
        if (chr == '.') continue;
        if (!rowSet.get(row).add(chr)
            || !colSet.get(col).add(chr)
            || !squares.get(row / 3).get(col / 3).add(chr)
        ) {
          return false;
        }
      }
    }
    return true;
  }
}
