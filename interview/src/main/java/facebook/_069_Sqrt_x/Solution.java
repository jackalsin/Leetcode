package facebook._069_Sqrt_x;

public class Solution {
  public int mySqrt(int x) {
    assert x >= 0;
    if (x <= 1) {
      return x;
    }

    int left = 1, right = x;
    while (left <= right) {
      final int mid = (right - left) / 2 + left;
      if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
        return mid;
      } else if (mid < x / mid) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    throw new IllegalStateException("You should not reach here");
  }
}
