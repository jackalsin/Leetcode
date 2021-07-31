package airbnb.hilbertCurve;

public final class SolutionIII implements Solution {
  /**
   * TODO:
   *
   * @param x
   * @param y
   * @param iter
   * @return
   */
  @Override
  public int hilbertCurve(int x, int y, int iter) {
    if (iter < 0) throw new IllegalArgumentException();
    if (iter == 0) return 1;
    final int midVal = 1 << (iter - 1),
        quarterCount = midVal * midVal;
    if (x >= midVal && y >= midVal) { // top right
      return 2 * quarterCount + hilbertCurve(x - midVal, y - midVal, iter - 1);
    } else if (x >= midVal && y < midVal) { // bottom right
      return 3 * quarterCount + hilbertCurve(midVal - y - 1, midVal - (x - midVal) - 1, iter - 1);
    } else if (x < midVal && y >= midVal) { // top left
      return quarterCount + hilbertCurve(x, y - midVal, iter - 1);
    } else { // bottom left
      return hilbertCurve(y, x, iter - 1);
    }
  }
}
