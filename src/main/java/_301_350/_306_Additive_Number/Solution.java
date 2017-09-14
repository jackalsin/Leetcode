package _301_350._306_Additive_Number;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class Solution {
  public boolean isAdditiveNumber(String num) {

    for (int firstEnd = 1; firstEnd <= num.length()/2; ++firstEnd) {
      if (num.charAt(0) == '0' && firstEnd > 1) break;
      long firstNum = Long.valueOf(num.substring(0, firstEnd));
      for (int secondEnd = firstEnd + 1; secondEnd < num.length(); ++secondEnd) {
        if (num.charAt(firstEnd) == '0' && secondEnd > firstEnd + 1) break;
        long secondNum = Long.valueOf(num.substring(firstEnd, secondEnd));

        long sumNum = firstNum + secondNum;
        String sum = String.valueOf(sumNum);
        if (num.startsWith(sum, secondEnd)) {
          if (isAdditiveNumber(num, secondEnd + sum.length(), secondNum, sumNum)) {
            return true;
          }
        }

      }
    }
    return false;
  }

  private boolean isAdditiveNumber(String num, int start, long first, long second) {
    if (start == num.length()) return true;
    long sum = first + second;
    String sumString = String.valueOf(sum);
    if (num.startsWith(sumString, start)) {
      return isAdditiveNumber(num, start + sumString.length(), second, sum);
    } else {
      return false;
    }
  }

}
