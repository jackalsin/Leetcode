package interviews.airbnb._251_Flatten_2D_Vector;

/**
 * @author jacka
 * @version 1.0 on 1/28/2019.
 */
public final class Vector2D {
  private int row, col;
  private final int[][] v;

  public Vector2D(int[][] v) {
    this.v = v;
    row = 0;
    col = 0;
  }

  public int next() {
    hasNext();
    final int res = v[row][col];
    col++;
    return res;
  }

  public boolean hasNext() {
    while (row < v.length && col == v[row].length) {
      row++;
      col = 0;
    }
    return row != v.length;
  }
}
