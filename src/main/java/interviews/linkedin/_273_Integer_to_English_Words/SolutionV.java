package interviews.linkedin._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 7/16/2019
 */
public final class SolutionV implements Solution {
  private static final String[] TWENTIES = {
      "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  }, TENS = {
      "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSAND = {"", "Thousand", "Million", "Billion"};
  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    final Deque<String> stack = new ArrayDeque<>();
    if (num == 0) {
      return "Zero";
    }
    int thousandIndex = 0;
    while (num > 0) {
      final int threeDigits = num % 1000;
      num /= 1000;
      final String three = getThree(threeDigits);
      if (!three.isEmpty()) {
        if (thousandIndex != 0) {
          stack.push(THOUSAND[thousandIndex]);
        }
        stack.push(three);
      }
      thousandIndex++;
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getThree(final int threeDigits) {
    final int ones = threeDigits % 10, tens = (threeDigits / 10) % 10, hundred = threeDigits / 100,
        lastTwo = threeDigits % 100;
    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(TWENTIES[hundred]).append(" ").append(HUNDRED);
    }
    if (lastTwo > 0 && lastTwo < 20) {
      sb.append(" ").append(TWENTIES[lastTwo]);
    } else {
      if (tens != 0) {
        sb.append(" ").append(TENS[tens]);
      }
      if (ones != 0) {
        sb.append(" ").append(TWENTIES[ones]);
      }
    }
    return sb.length() == 0 ? sb.toString() : sb.substring(1);
  }

}
