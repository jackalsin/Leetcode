package tableau._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
public final class SolutionI implements Solution {
  private static final String[] ONES = {
      "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  }, TENS = {
      "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSANDS = {"", "Thousand", "Million", "Billion"};

  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = 0;
    while (num != 0) {
      final int curThree = num % 1000;
      final String format = getFormat(curThree);
      if (!format.isEmpty()) {
        if (thousandIndex != 0) {
          stack.push(THOUSANDS[thousandIndex]);
        }
        stack.push(getFormat(curThree));
      }
      thousandIndex++;
      num /= 1000;
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getFormat(final int num) {
    if (num == 0) {
      return "";
    }
    final int hundred = num / 100, lastTwo = num % 100, ten = (num / 10) % 10, one = num % 10;
    final StringBuilder sb = new StringBuilder();
    if (hundred > 0) {
      sb.append(" ").append(ONES[hundred]).append(" ").append(HUNDRED);
    }
    if (lastTwo > 0 && lastTwo < 20) {
      sb.append(" ").append(ONES[lastTwo]);
    } else if (lastTwo >= 20) {
      sb.append(" ").append(TENS[ten]);
      if (one > 0) {
        sb.append(" ").append(ONES[one]);
      }
    }
    return sb.substring(1);
  }
}
