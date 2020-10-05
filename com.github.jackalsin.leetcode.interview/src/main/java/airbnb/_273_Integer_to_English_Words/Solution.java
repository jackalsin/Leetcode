package airbnb._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/2/2019.
 */
public class Solution {
  private static final String[] LESS_THAN_20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"},
      TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"},
      THOUSANDS = {"", "Thousand", "Million", "Billion"};
  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) {
      return LESS_THAN_20[0];
    }
    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = 0;
    while (num != 0) {
      final int curThree = num % 1000;
      num /= 1000;
      final String curThreeString = getThree(curThree);
      if (curThreeString.length() != 0) {
        if (THOUSANDS[thousandIndex].length() != 0) {
          stack.push(THOUSANDS[thousandIndex]);
        }
        stack.push(curThreeString);
      }

      thousandIndex++;
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getThree(int num) {
    if (num == 0) {
      return "";
    }
    final int ones = num % 10, lastTwo = num % 100, tens = lastTwo / 10, hundreds = num / 100;
    final StringBuilder sb = new StringBuilder();
    if (hundreds != 0) {
      sb.append(" ").append(LESS_THAN_20[hundreds]).append(" ").append(HUNDRED);
    }
    if (lastTwo > 0 && lastTwo < 20) {
      sb.append(" ").append(LESS_THAN_20[lastTwo]);
    } else if (lastTwo >= 20) {
      sb.append(" ").append(TENS[tens]);
      if (ones > 0) {
        sb.append(" ").append(LESS_THAN_20[ones]);
      }
    }
    return sb.substring(1);
  }
}
