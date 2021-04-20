package facebook._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/19/2021
 */
public final class SolutionII implements Solution {
  private static final String[] TWENTY = {
      "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  }, TENS = {
      //0 10  20
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  }, THOUSANDS = {
      "", "Thousand", "Million", "Billion"
  };

  private static final String HUNDRED = "Hundred";

  public String numberToWords(int num) {
    if (num == 0) return TWENTY[0];
    final Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; num != 0; ++i, num /= 1000) {
      final int lastThree = num - num / 1000 * 1000;
      if (lastThree != 0) {
        final String lastThreeString = getString(lastThree);
        if (lastThreeString.isEmpty()) continue;
        if (i != 0) stack.push(THOUSANDS[i]);
        stack.push(lastThreeString);
      }
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.substring(1);
  }

  private static String getString(final int num) {
    final int h = num / 100, t = num / 10 % 10, o = num % 10, last2 = num % 100;
    final StringBuilder sb = new StringBuilder();
    if (h != 0) {
      sb.append(" ").append(TWENTY[h]).append(" ").append(HUNDRED);
    }
    if (last2 == 0) {

    } else if (last2 < 20) {
      sb.append(" ").append(TWENTY[last2]);
    } else {
      sb.append(" ").append(TENS[t]);
      if (o != 0) {
        sb.append(" ").append(TWENTY[o]);
      }
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }
}
