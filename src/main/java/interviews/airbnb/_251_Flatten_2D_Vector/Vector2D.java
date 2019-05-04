package interviews.airbnb._251_Flatten_2D_Vector;

/**
 * @author jacka
 * @version 1.0 on 1/28/2019.
 */
public final class Vector2D {
  private int row = 0, col = 0;
  private final int[][] v;
  private final int rows;

  public Vector2D(int[][] v) {
    this.v = v;
    this.rows = v.length;
  }

  public int next() {
    assert hasNext();
    return v[row][col++];
  }

  public boolean hasNext() {
    while (row < rows && col == v[row].length) {
      col = 0;
      row++;
    }
    return row != v.length && col < v[row].length;
  }
}
