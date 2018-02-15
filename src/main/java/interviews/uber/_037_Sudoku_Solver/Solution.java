package interviews.uber._037_Sudoku_Solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/14/2018.
 */
public final class Solution {
  private static final Set<Character> TEMPLATE = new HashSet<>() {{
    addAll(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
  }};

  private static final int ROWS = 9, COLS = 9;

  public void solveSudoku(char[][] board) {
    solve(board, 0, 0, new HashSet<>(TEMPLATE));
  }

  private boolean solve(final char[][] board, int row, int col, final Set<Character> candidates) {
    if (col == COLS) {
      row++;
      col = 0;
      if (row == ROWS) {
        return true;
      }
      return solve(board, row, col, new HashSet<>(TEMPLATE));
    }
    if (board[row][col] == '.') {
      final Set<Character> newCandidates = new HashSet<>(candidates);
      for (char candidate : candidates) {
        board[row][col] = candidate;
        newCandidates.remove(candidate);
        if (isValidCol(board, col) && isValidSquare(board, row / 3 * 3, col / 3 * 3)) {
          boolean result = solve(board, row, col + 1, newCandidates);
          if (result) {
            return true;
          }
        }
        newCandidates.add(candidate);
        board[row][col] = '.';
      }
    } else {
      if (!candidates.contains(board[row][col])) {
        return false;
      }
      candidates.remove(board[row][col]);
      boolean result = solve(board, row, col + 1, candidates);
      if (result) {
        return true;
      }
      candidates.add(board[row][col]);
    }
    return false;
  }

  static boolean isValidSquare(final char[][] board, final int startRow, final int startCol) {
    final Set<Character> candidates = new HashSet<>(TEMPLATE);
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        final char chr = board[startRow + row][startCol + col];
        if (chr != '.') {
          if (candidates.contains(chr)) {
            candidates.remove(chr);
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  static boolean isValidCol(final char[][] board, final int col) {
    final int rows = board.length;
    final Set<Character> candidates = new HashSet<>(TEMPLATE);
    for (int row = 0; row < rows; row++) {
      final char chr = board[row][col];
      if (chr != '.') {
        if (candidates.contains(chr)) {
          candidates.remove(chr);
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
