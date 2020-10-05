package _0451_0500._479_Largest_Palindrome_Product;

public class Solution {
  private static final int MOD = 1337;

  private static final int[] TENS = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};

  public int largestPalindrome(int n) {

    if (n == 1) {
      return 9;
    }
    final int lowerBoundary = TENS[n - 1], upperBoundary = TENS[n];
    for (int curLeft = upperBoundary - 1; curLeft > 0; curLeft--) {
      final long cur = (long) curLeft * upperBoundary + getReverse(curLeft);
      for (int one = (int) Math.sqrt(cur); one >= lowerBoundary; one--) {
        final int other = (int) (cur / one);
        if (other >= upperBoundary) {
          break;
        }
        if (cur % one == 0) {
          return (int) (cur % MOD);
        }
      }
    }
    throw new IllegalStateException("Not found for n = " + n);
  }

  private int getReverse(int curLeft) {
    int res = 0;
    while (curLeft != 0) {
      res = res * 10 + curLeft % 10;
      curLeft /= 10;
    }
    return res;
  }

}
