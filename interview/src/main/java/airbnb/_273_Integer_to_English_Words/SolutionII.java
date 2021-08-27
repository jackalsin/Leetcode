package airbnb._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/26/2021
 */
public final class SolutionII implements Solution {
  private static final String[] ONES = {
      "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
      "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  }, TENS = {
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
      "Seventy", "Eighty", "Ninety",
  }, THOUSANDS = {
      "", "Thousand", "Million", "Billion"
  };
  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) return "Zero";
    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = 0;
    while (num != 0) {
      final String thisThree = getThree(num % 1000);
      if (thousandIndex != 0 && !thisThree.isEmpty()) stack.push(THOUSANDS[thousandIndex]);
      if (!thisThree.isEmpty()) stack.push(thisThree);
      num /= 1000;
      thousandIndex++;
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.substring(1);
  }

  private static String getThree(final int n) {
    if (n == 0) return "";
    final int hundred = n / 100, last2 = n % 100,
        ten = last2 / 10, one = last2 % 10;
    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(ONES[hundred]).append(" ").append(HUNDRED);
    }
    if (last2 != 0) {
      if (last2 < 20) {
        sb.append(" ").append(ONES[last2]);
      } else {
        sb.append(" ").append(TENS[ten]);
        if (one != 0) {
          sb.append(" ").append(ONES[one]);
        }
      }
    }

    return sb.substring(1);
  }
}
