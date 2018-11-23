package _0251_0300._263_Ugly_Number;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class Solution {
  public boolean isUgly(int num) {
    if (num <= 0) return false;
    if (num == 1) {
      return true;
    } else if (num % 2 == 0) {
      return isUgly(num / 2);
    } else if (num % 3 == 0) {
      return isUgly(num / 3);
    } else if (num % 5 == 0) {
      return isUgly(num / 5);
    } else {
      return false;
    }
  }
}
