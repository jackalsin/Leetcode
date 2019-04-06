package interviews.airbnb.hilbertCurve;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionII implements Solution {

  @Override
  public int hilbertCurve(int x, int y, int iter) {
    if (iter < 0) {
      throw new IllegalArgumentException("itr must be positive, but " + iter);
    }
    if (iter == 0) {
      return 1;
    }
    final int pointInQuarter = iter * iter;
    if (x >= iter && y >= iter) {
      return pointInQuarter * 2 + hilbertCurve(x - iter, y - iter, iter - 1);
    } else if (x >= iter && y < iter) {
      return pointInQuarter * 3 + hilbertCurve(iter - 1 - y, iter - 1 - (x - iter), iter - 1);
    } else if (x < iter && y < iter) {
      return hilbertCurve(y, x, iter - 1);
    } else {
      assert x < iter && y >= iter;
      return pointInQuarter + hilbertCurve(x, y - iter, iter - 1);
    }
  }
}
