package airbnb._251_Flatten_2D_Vector;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class Vector2DII implements Vector2D {
  private final int[][] vec;
  private int row = 0, col = 0;

  public Vector2DII(int[][] vec) {
    this.vec = vec;
  }

  public int next() {
    hasNext();
    final int res = vec[row][col];
    col++;
    return res;
  }

  public boolean hasNext() {
    if (row == vec.length) return false;
    while (col == vec[row].length) {
      col = 0;
      row++;
      if (row == vec.length) return false;
    }
    return true;
  }
}
