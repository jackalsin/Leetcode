package linkedin._069_Sqrt_x;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public class BinarySearchSolutionI implements Solution {
  @Override
  public int mySqrt(int x) {
    if (x < 0) {
      return -1;
    }
    long left = 0, right = x;
    while (left <= right) {
      final long mid = left + (right - left) / 2;
      if (mid * mid <= x && x < (mid + 1) * (mid + 1)) {
        return (int) mid;
      } else if (mid * mid > x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1; // not found
  }
}
