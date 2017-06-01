package _051_100._066_Plus_One;

/**
 * @author jacka
 * @version 1.0 on 4/25/2017.
 */
public class Solution {
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      digits[i]++;
      if (digits[i] <= 9) {
        return digits;
      }
      digits[i] = 0;
    }
    int[] newDigits = new int[len + 1];
    newDigits[0] = 1;
    return newDigits;
  }
}
