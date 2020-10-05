package linkedin._633_Sum_of_Square_Numbers;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class TwoPointerSolutionI implements Solution {
  @Override
  public boolean judgeSquareSum(int c) {
    if (c < 0) {
      return false;
    }
    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      final long sum = (long) left * left + (long) right * right;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        ++left;
      } else {
        --right;
      }
    }
    return false;
  }
}
