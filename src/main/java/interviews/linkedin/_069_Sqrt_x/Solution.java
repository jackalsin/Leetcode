package interviews.linkedin._069_Sqrt_x;

public class Solution {
  public int mySqrt(int x) {
    long left = 0, right = x;
    while (left <= right) {
      final long mid = (right - left) / 2 + left;
      if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
        return (int) mid;
      } else if ((mid + 1) * (mid + 1) <= x) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    throw new IllegalStateException();
  }

}
