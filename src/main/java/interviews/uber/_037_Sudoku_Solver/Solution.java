package interviews.uber._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/14/2018.
 */
public final class Solution {
  private static final Set<Character> TEMPLATE = new HashSet<>();

  static {
    for (int i = 1; i <= 9; i++) {
      TEMPLATE.add((char) ('0' + i));
    }
  }

  private static final int ROWS = 9, COLS = 9;

  public void solveSudoku(char[][] board) {
    solveRow(board, 0);
  }

  private static boolean solveRow(final char[][] board, final int row) {
    if (row == ROWS) {
      return true;
    }

    final Set<Character> candidates = new HashSet<>(TEMPLATE);
    for (int col = 0; col < COLS; col++) {
      candidates.remove(board[row][col]);
    }

    return solveCol(board, row, 0, candidates);
  }

  private static boolean solveCol(final char[][] board, int row, final int col, Set<Character> candidates) {
    if (col == COLS) {
      return solveRow(board, row + 1);
    }
    if (board[row][col] != '.') {
      return solveCol(board, row, col + 1, candidates);
    }
    final Set<Character> nextCandidates = new HashSet<>(candidates);
    for (char chr : candidates) {
      board[row][col] = chr;
      nextCandidates.remove(chr);
      if (isValid(board, row, col)
          && solveCol(board, row, col + 1, nextCandidates)) {
        return true;
      }
      nextCandidates.add(chr);
      board[row][col] = '.';
    }

    return false;
  }

  private static boolean isValid(final char[][] board, final int row, final int col) {
    return isValidCol(board, row, col) && isValidSquare(board, row, col);
  }

  private static boolean isValidCol(final char[][] board, int row, int col) {
    Set<Character> visited = new HashSet<>();
    for (int r = 0; r < ROWS; r++) {
      final char chr = board[r][col];
      if (chr != '.' && visited.contains(chr)) {
        return false;
      }
      visited.add(chr);
    }
    return true;
  }

  private static boolean isValidSquare(char[][] board, int row, int col) {
    final int baseRow = row / 3 * 3, baseCol = col / 3 * 3;
    Set<Character> visited = new HashSet<>();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        final char chr = board[baseRow + i][baseCol + j];
        if (chr != '.' && visited.contains(chr)) {
          return false;
        }
        visited.add(chr);
      }
    }
    return true;
  }
}
