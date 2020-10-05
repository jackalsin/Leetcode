package facebook._273_Integer_to_English_Words;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {
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
    if (num == 0) {
      return TWENTY[0];
    }

    final Deque<String> stack = new ArrayDeque<>();
    int thousand = 0;
    while (num != 0) {
      final int threeDigits = num % 1000;
      num /= 1000;
      final String threeDigitsString = getThousand(threeDigits);
      if (!threeDigitsString.isEmpty()) {
        if (thousand != 0) { // we don't insert for the one below 1000
          stack.push(THOUSANDS[thousand]);
        }
        stack.push(threeDigitsString);
      }
      thousand++;
    } // end of while loop

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  static String getThousand(int threeDigits) {
    final int hundred = threeDigits / 100, ones = threeDigits % 10, tens = (threeDigits / 10) % 10;
    final StringBuilder sb = new StringBuilder();
    if (hundred != 0) {
      sb.append(" ").append(TWENTY[hundred]).append(" ").append(HUNDRED);
    }
    final int lastTwo = tens * 10 + ones;
    if (lastTwo == 0) {
      return sb.length() == 0 ? "" : sb.substring(1);
    } else if (lastTwo < 20) {
      sb.append(" ").append(TWENTY[lastTwo]);
    } else {
      sb.append(" ").append(TENS[tens]);
      if (ones != 0) {
        sb.append(" ").append(TWENTY[ones]);
      }
    }

    return sb.length() == 0 ? "" : sb.substring(1);
  }
}
