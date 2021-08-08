package linkedin._069_Sqrt_x;

/**
 * @author jacka
 * @version 1.0 on 8/24/2019
 */
public class BinarySearchSolutionI implements Solution {
  @Override
  public int mySqrt(int x) {
    long left = 0, right = x + 1L;
    while (true) {
      final long mid = (left + right) / 2,
          prod = mid * mid;
      if (prod <= x && x < (mid + 1L) * (mid + 1L)) {
        return (int) mid;
      } else if (prod > x) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
  }
}
