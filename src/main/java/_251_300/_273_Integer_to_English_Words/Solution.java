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
    return null;
  }

  private String helper(int num) {
    if (num == 0) {
      return "";
    } else if (num < 20) {
      return LESS_THAN_20[num];
    } else if (num < 100) {
      return TENS[num / 10] + " " + LESS_THAN_20[num % 10];
    } else {
      return null;
    }
  }
}
