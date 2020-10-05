package linkedin._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 7/16/2019
 */
public final class SolutionV implements Solution {
  private static final String HUNDRED = "Hundred", ZERO = "Zero";
  private static final String[] ONES = {
      "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
      "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
  }, TENS = {
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
      "Ninety"
  }, THOUSAND = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) {
      return ZERO;
    }
    final Deque<String> stack = new ArrayDeque<>();
    for (int thousandIndex = 0; num != 0; num /= 1000, ++thousandIndex) {
      final int cur = num % 1000;
      final String curStr = getThree(cur);
      if (!curStr.isEmpty()) {
        final String thousand = THOUSAND[thousandIndex];
        if (!thousand.isEmpty()) {
          stack.push(thousand);
        }
        stack.push(curStr);
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.substring(1);
  }

  private static String getThree(final int cur) {
    final int hundred = cur / 100, two = cur - hundred * 100,
        ten = cur / 10 % 10, one = cur % 10;
    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(ONES[hundred]).append(" ").append(HUNDRED);
    }

    if (0 < two && two < 20) {
      sb.append(" ").append(ONES[two]);
    } else if (two >= 20) {
      sb.append(" ").append(TENS[ten]);
      if (one != 0) {
        sb.append(" ").append(ONES[one]);
      }
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }
}
