package interviews.google.trueFalseRectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public final class OMSquareNSolution implements Solution {
  public boolean existTrueRectangle(final boolean[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    final int rows = matrix.length, cols = matrix[0].length;
    if (rows < 2 || cols < 2) {
      return false;
    }
    final Map<Integer, Set<Integer>> colToCols = new HashMap<>();
    for (int row = 0; row < rows; row++) {
      for (int i = 0; i < cols; i++) {
        if (!matrix[row][i]) {
          continue;
        }
        for (int j = i + 1; j < cols; j++) {
          if (matrix[row][j]) {
            final Set<Integer> allCombination = colToCols.getOrDefault(i, new HashSet<>());
            if (allCombination.contains(j)) {
              return true;
            } else {
              allCombination.add(j);
              colToCols.put(i, allCombination);
            }
          }
        }
      }
    }
    return false;
  }
}
