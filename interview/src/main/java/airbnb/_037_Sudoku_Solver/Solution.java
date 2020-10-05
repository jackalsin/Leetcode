package airbnb._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public final class Solution {
  private static final int ROWS = 9, COLS = 9;
  private static final char EMPTY = '.';

  private static final Set<Integer> CANDIDATES = new HashSet<>();

  static {
    for (int i = 1; i <= 9; i++) {
      CANDIDATES.add(i);
    }
  }

  public void solveSudoku(char[][] board) {
    assert board.length == 9 && board[0].length == 9;

    final Set<Integer> cands = new HashSet<>(CANDIDATES);
    for (int col = 0; col < COLS; col++) {
      cands.remove((board[0][col] - '0'));
    }
    solveRow(board, 0, 0, cands);
  }

  private static boolean solveRow(char[][] board, int row, int col, final Set<Integer> cands) {
    if (col == COLS) {
      if (row == ROWS - 1) {
        return true;
      }
      final Set<Integer> nextCandidates = new HashSet<>(CANDIDATES);
      for (int j = 0; j < COLS; j++) {
        nextCandidates.remove(board[row + 1][j] - '0');
      }
      return solveRow(board, row + 1, 0, nextCandidates);
    } else if (board[row][col] != EMPTY) {
      return solveRow(board, row, col + 1, cands);
    }
    final Set<Integer> nextCandidates = new HashSet<>(cands);
    for (int num : cands) {
      final char chr = (char) ('0' + num);
      board[row][col] = chr;
      nextCandidates.remove(num);

      if (isValidCol(board, col) && isValidSquare(board, row, col) &&
          solveRow(board, row, col + 1, nextCandidates)) {
        return true;
      }
      nextCandidates.add(num);
      board[row][col] = EMPTY;
    }
    return false;
  }

  static boolean isValidSquare(char[][] board, int curRow, int curCol) {
    final int startRow = curRow / 3 * 3, startCol = curCol / 3 * 3;
    final Set<Character> visited = new HashSet<>();
    for (int row = startRow; row < startRow + 3; row++) {
      for (int col = startCol; col < startCol + 3; col++) {
        final char chr = board[row][col];
        if (chr != EMPTY) {
          if (visited.contains(chr)) return false;
          visited.add(chr);
        }
      }
    }
    return true;
  }

  static boolean isValidCol(char[][] board, int col) {
    final Set<Character> visited = new HashSet<>();
    for (int row = 0; row < ROWS; row++) {
      final char chr = board[row][col];
      if (chr != EMPTY) {
        if (visited.contains(chr)) {
          return false;
        }
        visited.add(chr);
      }
    }
    return true;
  }
}
