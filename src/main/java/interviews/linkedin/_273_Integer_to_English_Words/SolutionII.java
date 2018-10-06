package interviews.linkedin._273_Integer_to_English_Words;


import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionII implements Solution {
  private static final String TWENTIES[] = {
      "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
      "Nineteen"
  }, TENS[] = {"", "TEN", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSANDS[] = {"", "Thousand", "Million", "Billion"}, HUNDRED = "Hundred";

  @Override
  public String numberToWords(int num) {
    if (num == 0) {
      return TWENTIES[0];
    }
    final Deque<String> stack = new ArrayDeque<>();

    int thousandIndex = -1;
    while (num != 0) {
      int curThree = num % 1000;
      num /= 1000;
      thousandIndex++;
      final String curThreeStr = getCurThreeStr(curThree);
      if (curThreeStr.length() == 0) {
        continue;
      }
      if (THOUSANDS[thousandIndex].length() != 0) {
        stack.push(THOUSANDS[thousandIndex]);
      }
      stack.push(curThreeStr);
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getCurThreeStr(int num) {
    if (num == 0) {
      return "";
    }
    int ones = num % 10, hundreds = num / 100, tens = (num / 10) % 10, lastTwo = num % 100;
    final StringBuilder sb = new StringBuilder();
    if (hundreds != 0) {
      sb.append(" ").append(TWENTIES[hundreds]).append(" ").append(HUNDRED);
    }
    if (0 < lastTwo && lastTwo < 20) {
      sb.append(" ").append(TWENTIES[lastTwo]);
    } else {
      if (tens > 0) {
        sb.append(" ").append(TENS[tens]);
      }

      if (ones > 0) {
        sb.append(" ").append(TWENTIES[ones]);
      }
    }
    return sb.substring(1);
  }
}
