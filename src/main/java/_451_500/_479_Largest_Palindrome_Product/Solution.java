package _451_500._479_Largest_Palindrome_Product;

public class Solution {
  private static final int MOD = 1337;

  private static final int[] TENS = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};

  public int largestPalindrome(int n) {
    return 0;
//    final int productDigits = n * 2;
//    long maxProduct = getMaxNDigits(productDigits), min = getMinNDigits(n),
//        max = getMaxNDigits(n);
//    for (long product = maxProduct; product > 0; product--) {
//      if (!isPalindrome(product)) continue;
//      for (long one = (long) Math.sqrt(product); one >= min; one--) {
//        if (product % one == 0) {
//          long other = (product / one);
//          if (other > max) {
//            break;
//          } else {
//            System.out.println(one + " " + other);
////            return (int) (product % MOD);
//            return 0;
//          }
//        }
//      }
//    }
//
//    throw new IllegalStateException("Not found n = " + n);
  }

  private boolean isPalindrome(long product) {
    final String s = String.valueOf(product);
    return new StringBuilder(s).reverse().toString().equals(s);
  }

  private static int getMinNDigits(int n) {
    assert n >= 0;
    int res = 0;
    while (n-- > 0) {
      res *= 10;
    }
    return res;
  }

  private static long getMaxNDigits(int n) {
    assert n >= 0;
    long res = 0;
    while (n-- > 0) {
      res = res * 10 + 9;
    }
    return res;
  }
}
