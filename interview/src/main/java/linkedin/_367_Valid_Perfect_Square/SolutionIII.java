package linkedin._367_Valid_Perfect_Square;

/**
 * @author jacka
 * @version 1.0 on 8/12/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public boolean isPerfectSquare(int num) {
    if (num <= 0) {
      return false;
    }
    int left = 1, right = num;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (num % mid == 0 && num / mid == mid) {
        return true;
      }
      if (num / mid > mid) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
