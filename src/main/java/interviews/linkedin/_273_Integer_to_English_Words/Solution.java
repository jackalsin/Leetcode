package interviews.linkedin._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  // TODO: revisit
  private static final String[] ONES = {
      "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
      "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
      "Eighteen", "Nineteen", "Twenty"
  }, TENS = {
      "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSANDS = {
      "", "Thousand", "Million", "Billion"
  };

  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) {
      return ONES[0];
    }
    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = -1;
    while (num != 0) {
      final int curThree = num % 1000;
      num /= 1000;
      final String numStr = getThousand(curThree);
      ++thousandIndex;
      if (numStr.isEmpty()) {
        continue;
      }
      stack.push(THOUSANDS[thousandIndex]);
      stack.push(numStr);
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
      final String thousandStr = stack.pop();
      if (!thousandStr.isEmpty()) {
        sb.append(" ").append(thousandStr);
      }
    }
    return sb.substring(1);
  }

  private String getThousand(int curThree) {
    if (curThree == 0) {
      return "";
    }
    final int ones = curThree % 10, tens = curThree / 10 % 10, hundred = curThree / 100;
    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(ONES[hundred]).append(" ").append(HUNDRED);
    }
    if (tens >= 2) {
      sb.append(" ").append(TENS[tens]);
      if (ones != 0) {
        sb.append(" ").append(ONES[ones]);
      }
    } else {
      if (tens * 10 + ones != 0) {

        sb.append(" ").append(ONES[tens * 10 + ones]);
      }
    }
    return sb.length() > 0 ? sb.substring(1) : "";
  }
}
