package interviews.linkedin._273_Integer_to_English_Words;


import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionIII implements Solution {
  private static final String[] TWENTIES = {
      "Zero", "One", "Two", "Three", "Four", "Five",
      "Six", "Seven", "Eight", "Nine", "Ten",
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
      "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
  }, TENS = {
      "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
      "Eighty", "Ninety"
  }, THOUSANDS = {
      "", "Thousand", "Million", "Billion"
  };

  @Override
  public String numberToWords(int num) {
    if (num == 0) {
      return TWENTIES[0];
    }
    final Deque<String> stack = new ArrayDeque<>();
    int thousandIndex = -1;
    while (num != 0) {
      final int curNum = num % 1000;
      thousandIndex++;
      num /= 1000;
      final String curNumString = getThreeDigit(curNum);
      if (curNumString.length() == 0) {
        continue;
      }
      if (THOUSANDS[thousandIndex].length() != 0) {
        stack.push(THOUSANDS[thousandIndex]);
      }
      stack.push(curNumString);
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(" ").append(stack.pop());
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static String getThreeDigit(int curNum) {
    if (curNum == 0) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    final int hundred = curNum / 100, ten = (curNum / 10) % 10,
        one = curNum % 10, lastTwo = curNum % 100;
    if (hundred != 0) {
      sb.append(" ").append(TWENTIES[hundred]).append(" Hundred");
    }

    if (0 < lastTwo && lastTwo < 20) {
      sb.append(" ").append(TWENTIES[lastTwo]);
    } else {
      if (ten != 0) {
        sb.append(" ").append(TENS[ten]);
      }
      if (one != 0) {
        sb.append(" ").append(TWENTIES[one]);
      }
    }

    return sb.length() == 0 ? "" : sb.substring(1);
  }
}
