package _0551_0600._564_Find_the_Closest_Palindrome;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {
  private static final Set<String> ONES = new HashSet<>();
  private static final String ZERO = "0",
      ONE = "1", NEG_ONE = "-1";

  static {
    for (int i = 1; i <= 10; i++) {
      ONES.add(String.valueOf(i));
    }
  }

  public String nearestPalindromic(String str) {
    final char[] chars = str.toCharArray();
    final int n = str.length();
    if (ONES.contains(str)) {
      final int num = Integer.parseInt(str);
      return String.valueOf(num - 1);
    }
    if (isAllNine(chars)) {
      return getOneZeroOne(n + 1);
    } else if (isOneZeroOneOrOneZero(chars)) {
      return getNine(n - 1);
    }

    final boolean isEvenLen = n % 2 == 0;
    final String root = isEvenLen ? str.substring(0, n / 2) : str.substring(0, n / 2 + 1);

    final BigInteger original = new BigInteger(str),
        equal = new BigInteger(getPalindrome(root, isEvenLen, ZERO)),
        equalDiff = equal.subtract(original).abs(),
        small = new BigInteger(getPalindrome(root, isEvenLen, NEG_ONE)),
        smallDiff = small.subtract(original).abs(),
        big = new BigInteger(getPalindrome(root, isEvenLen, ONE)),
        bigDiff = big.subtract(original).abs();
    if (equalDiff.equals(BigInteger.ZERO)) {
      if (smallDiff.compareTo(bigDiff) <= 0) {
        return small.toString();
      } else {
        return big.toString();
      }
    } else {
      final BigInteger minDiff = bigDiff.min(smallDiff),
          candidate = minDiff.equals(bigDiff) ? big : small;
      if (minDiff.compareTo(equalDiff) > 0) {
        return equal.toString();
      } else if (minDiff.compareTo(equalDiff) == 0) {
        return candidate.compareTo(equal) > 0 ? equal.toString() : candidate.toString();
      } else {
        return candidate.toString();
      }
    }
  }

  private static String getPalindrome(final String str, final boolean isEvenLen, final String toAdd) {
    final String numStr = new BigInteger(str).add(new BigInteger(toAdd)).toString();
    final char[] chars = new char[numStr.length() * 2 - (isEvenLen ? 0 : 1)];
    for (int i = 0, j = chars.length - 1; i <= j; ++i, --j) {
      final char c = numStr.charAt(i);
      chars[i] = chars[j] = c;
    }
    return String.valueOf(chars);
  }

  private static String getOneZeroOne(final int digits) {
    final char[] chars = new char[digits];
    Arrays.fill(chars, '0');
    chars[0] = chars[chars.length - 1] = '1';
    return String.valueOf(chars);
  }

  private static String getNine(final int digits) {
    final char[] chars = new char[digits];
    Arrays.fill(chars, '9');
    return String.valueOf(chars);
  }

  private static boolean isOneZeroOneOrOneZero(final char[] chars) {
    final int len = chars.length;
    if (chars[0] != '1' || (chars[len - 1] != '1' && chars[len - 1] != '0')) {
      return false;
    }
    for (int i = 1; i < len - 1; i++) {
      if (chars[i] == '0') continue;
      return false;
    }
    return true;
  }

  private static boolean isAllNine(final char[] chars) {
    for (char chr : chars) {
      if (chr != '9') {
        return false;
      }
    }
    return true;
  }
}
