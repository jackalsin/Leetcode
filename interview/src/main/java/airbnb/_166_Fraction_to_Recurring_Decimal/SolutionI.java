package airbnb._166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/19/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";
    final StringBuilder sb = new StringBuilder();
    long num = numerator, deno = denominator;
    final int sign = ((numerator < 0) ^ (denominator < 0)) ? -1 : 1;
    if (sign < 0) {
      sb.append('-');
      num = Math.abs(num);
      deno = Math.abs(deno);
    }
    final long integerPart = num / deno;
    sb.append(integerPart);
    num = num % deno;
    if (num == 0) return sb.toString();
    sb.append(".");
    final Map<Long, Integer> remainToIndex = new HashMap<>();
    remainToIndex.put(num, sb.length());
    while (num != 0) {
      num = num * 10;
      sb.append(num / deno);
      num %= deno;
      if (remainToIndex.containsKey(num)) {
        final int index = remainToIndex.get(num);
        sb.insert(index, '(');
        sb.append(")");
        break;
      } else {
        remainToIndex.put(num, sb.length());
      }
    }
    return sb.toString();
  }
}
