package _051_100._079_Word_Search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
public class Solution {
  private static final int[][] DIRS = new int[][] {
      {1, 0}, {0, 1}, {0, -1}, {-1, 0},
  };
  private final Set<List<Integer>> visited = new HashSet<>();

  public boolean exist(char[][] board, String word) {
    if (word == null || word.isEmpty()) {
      return true;
    }
    int rows = board.length;
    int cols = board[0].length;
    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        if (board[row][col] == word.charAt(0)) {
          visited.add(Arrays.asList(row, col));
          if (exist(board, word, row, col, 1)) {
            return true;
          }
          visited.remove(Arrays.asList(row, col));
        }
      }
    }
    return false;
  }

  private boolean exist(char[][] board,
                               String word, int startRow, int startCol, int index) {
    if (index == word.length()) {
      return true;
    } else {
      int rows = board.length;
      int cols = board[0].length;
      for (int[] dir: DIRS) {
        int curRow = startRow + dir[0];
        int curCol = startCol + dir[1];
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols) {
          continue;
        }
        List<Integer> curPos = Arrays.asList(curRow, curCol);
        if (!visited.contains(curPos) && word.charAt(index) == board[curRow][curCol]) {
          visited.add(curPos);
          if (exist(board, word, curRow, curCol, index + 1)) {
            return true;
          }
          visited.remove(curPos);
        }
      }
      return false;
    }
  }

}
