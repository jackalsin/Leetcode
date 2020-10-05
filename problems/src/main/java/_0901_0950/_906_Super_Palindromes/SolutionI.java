package _0901_0950._906_Super_Palindromes;

/**
 * @author zhixi
 * @version 1.0 on 9/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int superpalindromesInRange(String L, String R) {
    final long l = Long.parseLong(L), r = Long.parseLong(R);
    int result = 0;
    for (long i = (long) Math.sqrt(l); i * i <= r; ) {
      long p = nextGreaterThanOrEqualsP(i);
      if (p * p <= r && isP(p * p)) {
//        System.out.println("p = " + p + ", p * p = " + p * p);
        result++;
      }
      i = p + 1;
    }
    return result;
  }

  private static boolean isP(final long p) {
    final char[] chars = String.valueOf(p).toCharArray();
    final int n = chars.length;
    for (int i = 0, j = n - 1; i < j; ++i, --j) {
      if (chars[i] != chars[j]) return false;
    }
    return true;
  }

  private static long nextGreaterThanOrEqualsP(final long val) {
    final String str = String.valueOf(val);
    final int len = str.length();
    final String left = str.substring(0, (len + 1) / 2),
        nextLeft = String.valueOf(Long.parseLong(left) + 1),
        right = new StringBuilder(left.substring(0, len / 2)).reverse().toString(),
        nextRight = new StringBuilder(nextLeft.substring(0, len / 2)).reverse().toString();
    long result = Long.MAX_VALUE;
    final long leftRight = Long.parseLong(left + right), nextLeftRight = Long.parseLong(nextLeft + nextRight);
    if (leftRight >= val) {
      result = Math.min(result, leftRight);
    }
    if (nextLeftRight >= val) {
      result = Math.min(result, nextLeftRight);
    }
    return result;
  }
}
