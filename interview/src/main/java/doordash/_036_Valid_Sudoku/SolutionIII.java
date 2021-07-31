package doordash._036_Valid_Sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionIII implements Solution {
  private static final int N = 9;
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
      ), List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      ), List.of(
          new HashSet<>(),
          new HashSet<>(),
          new HashSet<>()
      ));
  private static final char DOT = '.';

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        final char chr = board[i][j];
        if (chr == DOT) continue;
        final Set<Character> rows = this.rows.get(i),
            cols = this.cols.get(j),
            squares = this.squares.get(i / 3).get(j / 3);
        if (!rows.add(chr) || !cols.add(chr) || !squares.add(chr)) return false;
      }
    }
    return true;
  }
}
