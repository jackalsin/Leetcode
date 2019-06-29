package interviews.linkedin._069_Sqrt_x;

public final class BinarySearchSolution implements Solution {
  public int mySqrt(int x) {
    assert x >= 0;
    if (x <= 1) {
      return x;
    }
    long left = 1, right = x;
    while (left <= right) {
      final long mid = (left + right) / 2,
          prod = mid * mid, prodPlus = (mid + 1) * (mid + 1);
      if (prod <= x && x < prodPlus) {
        return (int) mid;
      } else if (prod < x) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    throw new IllegalStateException("Should never come x = " + x);
  }

}
