package _0501_0550._519_Random_Flip_Matrix;

import java.util.Random;

public final class ShuffleSolution implements Solution {
  private final int[] val; // = new int[MAX_ROW * MAX_COL];
  private final int MAX_COUNT, rows, cols;
  private int index;

  public ShuffleSolution(int n_rows, int n_cols) {
    rows = n_rows;
    cols = n_cols;
    MAX_COUNT = n_rows * n_cols;
    val = new int[n_rows * n_cols];
    reset();
  }

  private static void swap(final int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public int[] flip() {
    final int i = val[index--];
    return new int[]{i / cols, i % cols};
  }


  public void reset() {
    final Random rand = new Random();
    val[0] = 0;
    for (int i = 1; i < rows * cols; ++i) {
      val[i] = i;
      swap(val, i, rand.nextInt(i + 1));
    }
    index = MAX_COUNT - 1;
  }

  public int[] getVal() {
    return val;
  }
}
