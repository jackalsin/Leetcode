package interviews.linkedin._633_Sum_of_Square_Numbers;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class Solution {
  public boolean judgeSquareSum(int c) {
    int start = 0, end = (int) Math.ceil(Math.sqrt(c));
    while (start <= end) {
      long res = start * start + end * end;
      if (res == c) {
        return true;
      } else if (res < c) {
        start++;
      } else {
        end--;
      }
    }
    return false;
  }
}
