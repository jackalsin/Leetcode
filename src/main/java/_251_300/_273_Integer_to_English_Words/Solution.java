package _251_300._273_Integer_to_English_Words;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/30/2017.
 */
public class Solution {
  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) return "Zero";
    StringBuilder sb = new StringBuilder();
    int power = 3;
    while (num != 0) {
      int divident = getPower(power);
      String cur1000 = helper(num / divident);
      if (!cur1000.isEmpty()) {
        sb.append(cur1000);
        if (!THOUSANDS[power].isEmpty()) {
          sb.append(" ").append(THOUSANDS[power]);
        }
      }
      num %= divident;
      power--;
    }

    return sb.substring(1);
  }

  private int getPower(int power) {
    int result = 1;
    while (power-- != 0) {
      result *= 1000;
    }
    return result;
  }

  private String helper(int num) {
    if (num == 0) {
      return "";
    } else if (num < 20) {
      return " " + LESS_THAN_20[num];
    } else if (num < 100) {
      return " " + TENS[num / 10] + helper(num % 10);
    } else if (num < 1000) {
      return " " + LESS_THAN_20[num / 100] + " Hundred" + helper(num % 100);
    } else {
      throw new IllegalStateException("Over 1000");
    }
  }
}
