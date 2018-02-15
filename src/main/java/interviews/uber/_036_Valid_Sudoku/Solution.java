package interviews.uber._036_Valid_Sudoku;

/**
 * @author jacka
 * @version 1.0 on 2/13/2018.
 */
public class Solution {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }
    final int rows = board.length, cols = board[0].length;
    // check row
    for (int row = 0; row < rows; row++) {
      final boolean[] visited = new boolean[9];
      for (int col = 0; col < cols; col++) {
        final char chr = board[row][col];
        if (Character.isDigit(chr)) {
          if (visited[chr - '1']) {
            System.err.println("Return false by row = " + row);
            return false;
          } else {
            visited[chr - '1'] = true;
          }
        }
      }
    }

    // check col
    for (int col = 0; col < cols; col++) {
      final boolean[] visited = new boolean[9];
      for (int row = 0; row < rows; row++) {
        final char chr = board[row][col];
        if (Character.isDigit(chr)) {
          if (visited[chr - '1']) {
            System.out.println("Return false by Col");
            return false;
          } else {
            visited[chr - '1'] = true;
          }
        }
      }
    }

    // check 3 by 3
    for (int startRow = 0; startRow < rows; startRow += 3) {
      for (int startCol = 0; startCol < cols; startCol += 3) {
        final boolean[] visited = new boolean[9];
        for (int delRow = 0; delRow < 3; delRow++) {
          for (int delCol = 0; delCol < 3; delCol++) {
            final char chr = board[startRow + delRow][startCol + delCol];
            if (Character.isDigit(chr)) {
              if (visited[chr - '1']) {
                System.out.println("Return false by 3 * 3");
                return false;
              } else {
                visited[chr - '1'] = true;
              }
            }
          }
        }
      }
    }
    return true;
  }
}
