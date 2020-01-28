package _0551_0600._592_Fraction_Addition_and_Subtraction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String fractionAddition(String s) {
    final List<Number> nums = new ArrayList<>();
    int sign = 1;
    for (int start = 0, end = 0; end < s.length(); end++) {
      while (end + 1 < s.length() && s.charAt(end + 1) != '/') {
        end++;
      }
      final int num1 = Integer.parseInt(s.substring(start, end + 1));
      end++; // '/'
      assert s.charAt(end) == '/';
      start = end + 1;
      while (end + 1 < s.length() && (s.charAt(end + 1) != '+' && s.charAt(end + 1) != '-')) {
        end++;
      }
      final int num2 = Integer.parseInt(s.substring(start, end + 1));
      nums.add(new Number(sign * num1, num2));
      if (end + 1 < s.length()) {
        sign = s.charAt(end + 1) == '+' ? 1 : -1;
      }
      start = end + 2;
    }
    long i = nums.get(0).i, j = nums.get(0).j;
    for (int k = 1; k < nums.size(); ++k) {
      final Number num2 = nums.get(k);
      final long up = i * num2.j + j * num2.i,
          down = j * num2.j,
          gcd = gcd(up, down);
      i = up / gcd;
      j = down / gcd;
    }
    return j > 0 ? (i + "/" + j) : ((-i) + "/" + (-j));
  }

  private static long gcd(long a, long b) {
    if (a < b) {
      return gcd(b, a);
    }
    while (b != 0) {
      final long c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  private static final class Number {
    private final long i, j;

    private Number(long i, long j) {
      this.i = i;
      this.j = j;
    }
  }
}
