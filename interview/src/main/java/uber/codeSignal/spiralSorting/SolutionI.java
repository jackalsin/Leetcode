package uber.codeSignal.spiralSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> spiralSorting(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }
    final int rows = matrix.length, cols = matrix[0].length;
    final List<List<Integer>> result = new ArrayList<>();
    for (int startRow = 0, endRow = rows - 1, startCol = 0, endCol = cols - 1; ; ) {
      final List<Integer> curList = new ArrayList<>();
      for (int col = startCol; col <= endCol; ++col) {
        curList.add(matrix[startRow][col]);
      }
      ++startRow;
      for (int row = startRow; row <= endRow; ++row) {
        curList.add(matrix[row][endCol]);
      }
      --endCol;
      if (startRow <= endRow) {
        for (int col = endCol; col >= startCol; --col) {
          curList.add(matrix[endRow][col]);
        }
        endRow--;
      }

      if (startCol <= endCol) {
        for (int row = endRow; row >= startRow; --row) {
          curList.add(matrix[row][startCol]);
        }
        startCol++;
      }
      if (curList.isEmpty()) break;
      result.add(curList);
      Collections.sort(curList);
    }
    return result;
  }
}
