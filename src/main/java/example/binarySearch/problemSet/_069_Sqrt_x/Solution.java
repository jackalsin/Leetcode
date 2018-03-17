package example.binarySearch.problemSet._069_Sqrt_x;

public class Solution {

  public int mySqrt(int x) {
    if (x <= 0) {
      return 0;
    }
    long left = 1, right = x;
    while (left <= right) {
      final long mid = (right - left) / 2 + left;
      if (mid * mid <= x && x < (mid + 1) * (mid + 1)) {
        return (int) mid;
      } else if (x < mid * mid) {
        right = mid - 1;
      } else {
        assert (mid + 1) * (mid + 1) <= x;
        // 因为 (mid + 1)^2 <= x, 所以sqrt(x)与mid之间夹着一个mid + 1, 所以也可以步进
        left = mid + 1;
      }
    }
    return -1;
  }
}
