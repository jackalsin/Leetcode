package linkedin._633_Sum_of_Square_Numbers;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class TwoPointerSolution implements Solution {
  @Override
  public boolean judgeSquareSum(int c) {
    if (c < 0) {
      return false;
    }
    long left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      final long prod = left * left + right * right;
      if (prod == c) {
        return true;
      } else if (prod < c) {
        ++left;
      } else {
        --right;
      }
    }
    return false;
  }
}
