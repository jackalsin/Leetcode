package doordash._036_Valid_Sudoku;

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

  public boolean isValidSudoku(char[][] board) {
    assert board != null && board.length == N && board[0].length == N;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (board[i][j] == DOT) continue;
        final int val = board[i][j] - '0';
        if (!rows.get(i).add(val)) return false;
        if (!cols.get(j).add(val)) return false;
        if (!squares.get(i / 3).get(j / 3).add(val)) return false;
      }
    }
    return true;
  }
}
