package interviews.google.trueFalseRectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public final class OMNSolution implements Solution {
  @Override
  public boolean existTrueRectangle(boolean[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    if (rows < 2 || cols < 2) {
      return false;
    }
    /**/
    final List<List<Integer>> trueIndexInEachRow = new ArrayList<>();
    for (boolean[] matrixRow : matrix) {
      List<Integer> trueIndex = new ArrayList<>();
      trueIndexInEachRow.add(trueIndex);
      for (int col = 0; col < cols; col++) {
        if (matrixRow[col]) {
          trueIndex.add(col);
        }
      }
    }

    for (int col = 0; col < cols; col++) {
      final Map<Integer, Integer> visitedColumns = new HashMap<>();
      /* the row index that matrix[row][col] is true */
      final List<Integer> candidateRows = getCandidateRows(matrix, col);
      /*
       * 这部分看起来是O(MN),但是看testOnlineCase2，
       * 也就是最恶劣的情况就是我这样了，这样是扫了所有的column，但凡要超过或等于cols，那么必定再列上面再有一个True
       * 也就是所有行列扫一遍，其实最多也就cols 个元素
       */
      for (int row : candidateRows) {
        final List<Integer> candidateCols = trueIndexInEachRow.get(row);
        for (int anotherCol : candidateCols) {
          if (anotherCol == col) {
            continue;
          } else if (visitedColumns.containsKey(anotherCol)) {
            final int anotherRow = visitedColumns.get(anotherCol);
            System.out.printf("[%d, %d], [%d, %d], [%d, %d], [%d, %d]\n", row, col, row,
                anotherCol, anotherRow, col, anotherRow, anotherCol);
            return true;
          } else {
            visitedColumns.put(anotherCol, row);
          }
        }
      }
    }
    return false;
  }

  private List<Integer> getCandidateRows(boolean[][] matrix, int col) {
    final List<Integer> result = new ArrayList<>();
    final int rows = matrix.length, cols = matrix[0].length;
    for (int row = 0; row < rows; row++) {
      if (matrix[row][col]) {
        result.add(row);
      }
    }
    return result;
  }
}
