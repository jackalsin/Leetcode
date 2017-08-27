package _251_300._258_Add_Digits;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class Solution {
  public int addDigits(int num) {
//    return solution(num);
    return o1Solution(num);
  }

  private int o1Solution(int num) {
    return 1 + (num - 1) % 9;
  }

  private int solution(int num) {
    int sum = 0;
    while (true) {
      if (num > 0) {
        sum += num % 10;
        num /= 10;
      } else if (num == 0) {
        if (sum >=   10) {
          num = sum;
          sum = 0;
        } else {
          return sum;
        }
      }
    }
  }

}
