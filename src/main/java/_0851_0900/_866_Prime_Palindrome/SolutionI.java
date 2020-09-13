package _0851_0900._866_Prime_Palindrome;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int primePalindrome(int N) {
    if (8 <= N && N <= 11) return 11;
    for (int left = 1; left < 100_000; ++left) {
      final String leftStr = Integer.toString(left),
          rightStr = new StringBuilder(leftStr).reverse().toString();
      final int candidate = Integer.parseInt(leftStr + rightStr.substring(1));
      if (candidate >= N && isPrime(candidate)) return candidate;
    }
    throw new IllegalStateException();
  }

  private static boolean isPrime(final int n) {
    if (n == 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (long i = 3; i * i <= n; i += 2) {
      if (n % i == 0) return false;
    }
    return true;
  }

}
