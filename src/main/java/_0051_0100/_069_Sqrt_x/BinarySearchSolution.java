package _0051_0100._069_Sqrt_x;

/**
 * @author jacka
 * @version 1.0 on 4/27/2017.
 */
public final class BinarySearchSolution implements Solution {

  public int mySqrt(int x) {
    if (x <= 0) {
      return 0;
    } else {
      int left = 1, right = x;
      while (left <= right) {
        int mid = (right - left) / 2 + left;
        if (mid * mid == x) {
          return mid;
        } else if (mid > x / mid) {
          right = mid - 1;
        } else {
          if ((mid + 1) > x / (mid + 1)) {
            return mid;
          }
          left = mid + 1;
        }
      }
      throw new IllegalStateException();
    }
  }
}
