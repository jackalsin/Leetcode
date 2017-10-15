package _601_650._633_Sum_of_Square_Numbers;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
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
