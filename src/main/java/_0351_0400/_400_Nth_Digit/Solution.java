package _0351_0400._400_Nth_Digit;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class Solution {
  public int findNthDigit(int n) {
    long count = 0L, curPhaseNum = 9;
    int digitsPerNum = 1, start = 1;
    while (count + digitsPerNum * curPhaseNum < n) {
      count += digitsPerNum * curPhaseNum;
      start += curPhaseNum;
      digitsPerNum++;
      curPhaseNum *= 10;
    }
    n = n - (int) count;
    int numDelta = n / digitsPerNum, digitDelta = n % digitsPerNum;
    int targetNum = start + numDelta - (digitDelta == 0 ? 1 : 0);
    return kthDigit(targetNum, digitDelta == 0 ? digitsPerNum : digitDelta);
  }

  private static int kthDigit(int targetNum, int k) {
    System.out.println(targetNum + "\t" + k);
    return String.valueOf(targetNum).charAt(k - 1) - '0';
  }
}
