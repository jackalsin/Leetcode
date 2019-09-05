package interviews.linkedin._367_Valid_Perfect_Square;

/**
 * @author jacka
 * @version 1.0 on 9/4/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public boolean isPerfectSquare(int num) {
    if (num <= 0) {
      return false;
    }
    int left = 1, right = num;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      final long prod = (long) mid * mid;
      if (prod == num) {
        return true;
      } else if (prod < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
