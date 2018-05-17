package interviews.pinterest.diaonalsInMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=354764&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class Solution {

  public List<List<Integer>> getDiagnals(final int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    final List<List<Integer>> result = new ArrayList<>();

    // right bottom
    final int[] rightBottom = {1, 1};
    for (int startRow = rows - 1, startCol = 0; ; startCol = startRow == 0 ? startCol + 1 : 0, startRow = Math.max(0, startRow - 1)) {
//      System.out.printf("%d, %d\n", startRow, startCol);
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      for (int row = startRow, col = startCol; isInRange(row, col, matrix); row += rightBottom[0], col += rightBottom[1]) {
        curLine.add(matrix[row][col]);
      }
      if (startRow == 0 && startCol == cols - 1) {
        break;
      }
    }
//    System.out.println();

    final int[] rightUp = {-1, 1};

    for (int startRow = 0, startCol = 0; ; startCol = startRow == rows - 1 ? (startCol + 1) : 0, startRow = Math.min(rows - 1, startRow + 1)) {
//      System.out.printf("%d, %d\n", startRow, startCol);
      final List<Integer> curLine = new ArrayList<>();
      result.add(curLine);
      for (int row = startRow, col = startCol; isInRange(row, col, matrix); row += rightUp[0], col += rightUp[1]) {
        curLine.add(matrix[row][col]);
      }
      if (startRow == rows - 1 && startCol == cols - 1) {
        break;
      }
    }

    return result;
  }

  private static boolean isInRange(int row, int col, int[][] matrix) {
    final int rows = matrix.length, cols = matrix[0].length;
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }
}
