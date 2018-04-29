package _501_550._504_Base_7;

public class Solution {
  /**
   * 241 / 241 test cases passed.
   * Status: Accepted
   * Runtime: 18 ms
   *
   * @param num
   * @return
   */
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    final String sign = num < 0 ? "-" : "";
    String number = "";
    num = Math.abs(num);
    while (num != 0) {
      number = (num % 7) + number;
      num /= 7;
    }
    return sign + number;
  }
}
