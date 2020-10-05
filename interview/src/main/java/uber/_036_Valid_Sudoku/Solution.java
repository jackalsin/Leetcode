package uber._036_Valid_Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/13/2018.
 */
public class Solution {
  public boolean isValidSudoku(char[][] board) {
    final int rows = board.length, cols = board[0].length;
    assert rows == 9 && cols == 9;
    final List<Set<Integer>> colSets = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      colSets.add(new HashSet<>());
    }
    for (int row = 0; row < rows; row++) {
      final Set<Integer> rowSet = new HashSet<>();
      for (int col = 0; col < cols; col++) {
        final Set<Integer> colSet = colSets.get(col);
        final char curChar = board[row][col];
        if (curChar == '.') continue;
        final int cur = curChar - '0';

        if (cur < 0 || cur > 9 || rowSet.contains(cur) || colSet.contains(cur)) {
          return false;
        }
        rowSet.add(cur);
        colSet.add(cur);
      }
    }

    for (int row = 0; row < rows; row += 3) {
      for (int col = 0; col < cols; col += 3) {
        final Set<Integer> visited = new HashSet<>();
        for (int rowDiff = 0; rowDiff < 3; rowDiff++) {
          for (int colDiff = 0; colDiff < 3; colDiff++) {
            final char curChar = board[row + rowDiff][col + colDiff];
            if (curChar == '.') continue;
            final int cur = board[row + rowDiff][col + colDiff];
            if (visited.contains(cur)) {
              return false;
            }
            visited.add(cur);
          }
        }
      }
    }
    return true;
  }
}
