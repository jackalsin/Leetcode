package explore.Leftmost_Column_with_at_Least_a_One;

import utils.Leftmost_Column_with_at_Least_a_One.BinaryMatrix;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
public final class SolutionI implements Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    final List<Integer> length = binaryMatrix.dimensions();
    final int rows = length.get(0), cols = length.get(1);
    int min = cols;
    for (int i = 0; i < rows; ++i) {
      while (min - 1 >= 0 && binaryMatrix.get(i, min - 1) == 1) {
        min--;
      }
    }
    return min == cols ? -1 : min;
  }
}
