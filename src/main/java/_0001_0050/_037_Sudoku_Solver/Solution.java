package _0001_0050._037_Sudoku_Solver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/16/2017.
 */
public class Solution {

  private static final Set<Character> TEMPLATE = new HashSet<>();

  static {
    for (int i = 0; i < 9; i++) {
      TEMPLATE.add((char) ('1' + i));
    }
  }

  /**
   * You may assume that there will be only one unique solution.
   *
   * @param board
   */
  public void solveSudoku(char[][] board) {
    solveRow(board, 0);
  }

  private boolean solveRow(char[][] board, int row) {
    if (row == board.length) {
      return true;
    } else {
      Set<Character> candidates = new HashSet<>(TEMPLATE);
      // get candidates
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] != '.') {
          candidates.remove(board[row][col]);
        }
      }
      return solveCol(board, row, 0, candidates);
    }
  }

  private boolean solveCol(char[][] board, int row, int col, Set<Character> candidates) {
    if (col == board[0].length) {
      return solveRow(board, row + 1);
    } else {
      if (board[row][col] == '.') {
        for (char candidate : candidates) {
          board[row][col] = candidate;
          Set<Character> remainingCandidates = new HashSet<>(candidates);
          remainingCandidates.remove(candidate);
          if (isValid(board, row, col)) {
            if (solveCol(board, row, col + 1, remainingCandidates)) {
              return true;
            }
          }
          board[row][col] = '.';
        }
        return false;
      } else {
        return solveCol(board, row, col + 1, candidates);
      }
    }
  }

  private boolean isValid(char[][] board, int row, int col) {
    return isValidInCol(board, col) && isValidInSquare(board, row, col);
  }

  static boolean isValidInSquare(char[][] board, int row, int col) {
    int startRow = row / 3 * 3, startCol = col / 3 * 3;
    Set<Character> hasSeen = new HashSet<>();
    for (int dx = 0; dx < 3; dx++) {
      for (int dy = 0; dy < 3; dy++) {
        char curCell = board[startRow + dx][startCol + dy];
        if (curCell != '.') {
          if (hasSeen.contains(curCell)) {
            return false;
          } else {
            hasSeen.add(curCell);
          }
        }
      }
    }
    return true;
  }

  static boolean isValidInCol(char[][] board, int col) {
    Set<Character> hasSeen = new HashSet<>();
    for (int row = 0; row < board.length; row++) {
      char curCell = board[row][col];
      if (curCell != '.') {
        if (hasSeen.contains(curCell)) {
          return false;
        } else {
          hasSeen.add(curCell);
        }
      }
    }
    return true;
  }
}
