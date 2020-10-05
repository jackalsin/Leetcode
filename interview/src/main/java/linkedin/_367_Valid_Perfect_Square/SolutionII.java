package linkedin._367_Valid_Perfect_Square;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionII implements Solution {

  public boolean isPerfectSquare(int num) {
    assert num > 0;

    int start = 1, end = num;
    while (start <= end) {
      final int mid = (end - start) / 2 + start;
      long prod = (long) mid * (long) mid;
      if (prod == num) {
        return true;
      } else if (prod < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }

}
