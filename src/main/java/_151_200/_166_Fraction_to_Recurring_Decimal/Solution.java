package _151_200._166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/29/2017.
 */
public class Solution {

  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";
    StringBuilder sb = new StringBuilder();
    sb.append((numerator > 0)^(denominator > 0) ? "-" : "");
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    sb.append(num/den);
    num = num % den;
    if (num == 0) {
      return sb.toString();
    }
    sb.append(".");
    Map<Long, Integer> numToIndex = new HashMap<>();
    numToIndex.put(num, sb.length());
    while (num != 0) {
      long curDigit = num * 10 / den;
      sb.append(curDigit);
      num = num * 10 % den;
      if (numToIndex.containsKey(num)) {
        sb.insert(numToIndex.get(num), "(");
        sb.append(")");
        break;
      } else {
        numToIndex.put(num, sb.length());
      }
    }
    return sb.toString();
  }
}
