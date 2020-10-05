package linkedin._273_Integer_to_English_Words;


import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionIV implements Solution {
  private static final String[] TWENTIES = {
      "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  }, TENS = {
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSAND = {
      "", "Thousand", "Million", "Billion"
  };
  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) {
      return TWENTIES[0];
    }

    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = -1;
    while (num != 0) {
      thousandIndex++;
      final int curNum = num % 1000;
      num /= 1000;
      final String curNumStr = getString(curNum);
      if (curNumStr.length() == 0) {
        continue;
      }
      if (thousandIndex != 0) {
        stack.push(THOUSAND[thousandIndex]);
      }
      stack.push(curNumStr);
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }

    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getString(final int num) {
    if (num == 0) {
      return "";
    }

    final int hundred = num / 100, ten = num / 10 % 10, ones = num % 10, lastTwo = num % 100;

    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(TWENTIES[hundred]).append(" ").append(HUNDRED);
    }
    if (0 < lastTwo && lastTwo < 20) {
      sb.append(" ").append(TWENTIES[lastTwo]);
    } else {
      if (ten != 0) {
        sb.append(" ").append(TENS[ten]);
      }
      if (ones != 0) {
        sb.append(" ").append(TWENTIES[ones]);
      }
    }

    return sb.length() == 0 ? "" : sb.substring(1);

  }
}
