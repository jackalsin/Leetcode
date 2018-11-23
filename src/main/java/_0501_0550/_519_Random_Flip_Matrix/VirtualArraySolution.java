package _0501_0550._519_Random_Flip_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class VirtualArraySolution implements Solution {
  private final Map<Integer, Integer> map = new HashMap<>();
  private final int rows, cols, maxCount;
  private int index;

  private final Random rand = new Random();

  public VirtualArraySolution(final int rows, final int cols) {
    this.rows = rows;
    this.cols = cols;
    maxCount = rows * cols;

    reset();
  }


  public int[] flip() {
    final int i = rand.nextInt(index--);
    int indexVal = map.getOrDefault(index, index);
    int iVal = map.getOrDefault(i, i);

    map.put(i, indexVal);
    map.put(index, iVal);
    return new int[]{iVal / cols, iVal % cols};
  }


  public void reset() {
    index = rows * cols;
  }
}
