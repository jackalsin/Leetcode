package interviews.microsoft._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
      "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private static final String[] TENS =
      {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    final Deque<String> stack = new ArrayDeque<>();
    while (num != 0) {
      final int lastThree = num % 1000;
      num /= 1000;
      final String numString = getNumString(lastThree);
      stack.push(numString.isEmpty() ? numString : numString.substring(1));
    }

    int thousandIndex = stack.size() - 1;
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      final String cur1000Str = stack.pop();
      final String thousand = THOUSANDS[thousandIndex--];
      if (cur1000Str.isEmpty()) {
        continue;
      }
      sb.append(" ").append(cur1000Str);
      if (!thousand.isEmpty()) {
        sb.append(" ").append(thousand);
      }
    }
    return sb.substring(1);
  }

  private static String getNumString(final int num) {
    assert num < 1000;
    if (num == 0) {
      return "";
    } else if (num < 20) {
      return " " + LESS_THAN_20[num];
    } else if (num < 100) {
      return " " + TENS[num / 10] + getNumString(num % 10);
    } else {
      final int hundredDigit = num / 100;
      return " " + LESS_THAN_20[hundredDigit] + " Hundred" + getNumString(num % 100);
    }
  }
}
