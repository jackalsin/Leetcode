package airbnb._251_Flatten_2D_Vector;

/**
 * @author jacka
 * @version 1.0 on 1/28/2019.
 */
public final class GenericVector2D<T> {
  private int row = 0, col = 0;
  private final T[][] v;
  private final int rows;

  public GenericVector2D(T[][] v) {
    this.v = v;
    this.rows = v.length;
  }

  public T next() {
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
