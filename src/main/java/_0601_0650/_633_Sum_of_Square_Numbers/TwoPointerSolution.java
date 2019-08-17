package _0601_0650._633_Sum_of_Square_Numbers;

/**
 * Time complexity: O(Sqrt(c))
 * Space complexity: O(1)
 *
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class TwoPointerSolution implements Solution {
  public boolean judgeSquareSum(int c) {
    if (c < 0) {
      return false;
    }
    int left = 0, right = (int) (Math.sqrt(c)) + 1;
    while (left <= right) {
      int sum = left * left + right * right;
      if (sum == c) {
        return true;
      } else if (sum < c) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }

}
