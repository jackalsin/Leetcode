package doordash._036_Valid_Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/5/2021
 */
public final class SolutionI implements Solution {
  private static final int N = 9;
  private static final char DOT = '.';

  public boolean isValidSudoku(char[][] board) {
    assert board.length == 9 && board[0].length == 9;
    final List<Set<Character>> colSets = new ArrayList<>();
    for (int i = 0; i < N; ++i) colSets.add(new HashSet<>());

    for (int row = 0; row < N; ++row) {
      final Set<Character> rows = new HashSet<>();
      for (int col = 0; col < N; ++col) {
        if (board[row][col] != DOT) {
          final char chr = board[row][col];
          if (!rows.add(chr)) return false;
          if (!colSets.get(col).add(chr)) return false;
        }
        if (row % 3 == 0 && col % 3 == 0 && !isValid9Square(board, row, col)) return false;
      }
    }
    return true;
  }

  private static boolean isValid9Square(final char[][] board, final int startRow, final int startCol) {
    final Set<Character> visited = new HashSet<>();
    for (int row = startRow; row < startRow + 3; row++) {
      for (int col = startCol; col < startCol + 3; ++col) {
        if (DOT == board[row][col]) continue;
        if (!visited.add(board[row][col])) return false;
      }
    }
    return true;
  }
}
