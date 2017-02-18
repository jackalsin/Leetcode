package _001_100._036_Valid_Sudoku;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/15/2017.
 */
public class Solution {
  private static final Map<Character, Integer> TEMPLATES = new HashMap<>();
  static {
    for (int i = 1; i <= 9; i++) {
      TEMPLATES.put((char) ('0' + i), i);
    }
  }

  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length == 0 ||
        board[0].length == 0 || (board.length != board[0].length) ) {
      return false;
    }
    return isValidInRows(board) && isValidInCols(board) && isValid3By3Square(board);
  }

  private static boolean isValidInRows(char[][] boards) {
    for (int i = 0; i < boards.length; i++) {
      Map<Character, Integer> curCounts = new HashMap<>(TEMPLATES);
      for (int j = 0; j < boards[0].length; j++) {
        char curChar = boards[i][j];
        if (curChar == '.') continue;
        if (curCounts.get(curChar) == 0) {
          return false;
        } else {
          curCounts.put(curChar, 0);
        }
      }
    }
    return true;
  }

  private static boolean isValidInCols(char[][] boards) {
    for (int i = 0; i < boards.length; i++) {
      Map<Character, Integer> curCounts = new HashMap<>(TEMPLATES);
      for (int j = 0; j < boards[0].length; j++) {
        char curChar = boards[j][i];
        if (curChar == '.') continue;
        if (curCounts.get(curChar) == 0) {
          return false;
        } else {
          curCounts.put(curChar, 0);
        }
      }
    }
    return true;
  }

  private static boolean isValid3By3Square(char[][] boards) {
    for (int startRow = 0; startRow < boards.length; startRow += 3) {
      for (int startCol = 0; startCol < boards[0].length; startCol += 3) {
        Map<Character, Integer> curCounts = new HashMap<>(TEMPLATES);
        for (int dx = 0; dx < 3; dx++) {
          for (int dy = 0; dy < 3; dy++) {
            char curChar = boards[startRow + dx][startCol + dy];
            if (curChar == '.') continue;
            if (curCounts.get(curChar) == 0) {
              return false;
            } else {
              curCounts.put(curChar, 0);
            }
          }
        }
      }
    }
    return true;
  }
}
