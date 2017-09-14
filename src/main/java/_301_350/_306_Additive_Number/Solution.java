package _301_350._306_Additive_Number;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class Solution {
  public boolean isAdditiveNumber(String num) {

    for (int firstEnd = 1; firstEnd <= num.length()/2; ++firstEnd) {
      long firstNum = Long.valueOf(num.substring(0, firstEnd));
      if (num.charAt(firstEnd) == '0') { // the second string starts with zero
        long secondNum = Long.valueOf(num.substring(firstEnd, firstEnd + 1)); // 0
        long sumNum = firstNum + secondNum; // firstNum
        String sumString = String.valueOf(sumNum);

        if (num.startsWith(sumString, firstEnd + 1) && isAdditiveNumber(num, firstEnd + 1 +
            sumString.length(), 0, firstNum)) {
          return true;
        }

      } else {
        for (int secondEnd = firstEnd + 1; secondEnd < num.length(); ++secondEnd) {
          long secondNum = Long.valueOf(num.substring(firstEnd, secondEnd));
          if (num.charAt(secondEnd) == '0') { // sum start with zero
            if (num.startsWith(String.valueOf(firstNum), secondEnd)) {
              return isAdditiveNumber(num, secondEnd + 1, secondNum, 0);
            }
          } else {
            long sumNum = firstNum + secondNum;
            String sum = String.valueOf(sumNum);
            if (num.startsWith(sum, secondEnd)) {
              if (isAdditiveNumber(num, secondEnd + sum.length(), secondNum, sumNum)) {
                return true;
              }
            }
          }
        }
        if (firstNum == 0) break;
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
