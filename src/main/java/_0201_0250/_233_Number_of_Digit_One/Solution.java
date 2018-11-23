package _0201_0250._233_Number_of_Digit_One;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public int countDigitOne(int n) {
    if (n <= 0) {
      return 0;
    } else if (n < 10) {
      return 1;
    } else {
      int digits = (int) Math.log10(n);
      int leading1 = (int) Math.pow(10, digits);
      int newly = Math.min(n, 2 * leading1 - 1) - leading1 + 1;
      int firstDigit = n / leading1;
      int removingFirstDigitsDigitOneCounts = countDigitOne(n - firstDigit * leading1);
      return newly + countDigitOne(leading1 - 1) * firstDigit + removingFirstDigitsDigitOneCounts;
    }
  }
}
