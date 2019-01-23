package interviews.airbnb._043_Multiply_Strings;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public class Solution {
  public String multiply(String num1, String num2) {
    final char[] n1 = num1.toCharArray(), n2 = num2.toCharArray(), res = new char[n1.length + n2.length + 1];
    Arrays.fill(res, '0');
    for (int resIndex = res.length - 1, n2Index = n2.length - 1; resIndex >= 0 && n2Index >= 0; resIndex--, n2Index--) {
      final char[] cur = multiply(n1, n2[n2Index]);
      add(res, cur, resIndex);
    }
    int offset = 0;
    while (offset < res.length && res[offset] == '0') {
      offset++;
    }
    return offset == res.length ? "0" : String.valueOf(res, offset, res.length - offset);
  }

  private static void add(char[] res, char[] cur, int resStart) {
    for (int resIndex = resStart, curIndex = cur.length - 1, carry = 0; resIndex >= 0 || curIndex >= 0 || carry != 0; resIndex--, curIndex--) {
      final int a = resIndex >= 0 ? res[resIndex] - '0' : 0,
          b = curIndex >= 0 ? cur[curIndex] - '0' : 0, sum = a + b + carry, ones = sum % 10;
      res[resIndex] = (char) (ones + '0');
      carry = sum / 10;
    }
  }

  private static char[] multiply(final char[] n1, final char c) {
    final char[] res = new char[n1.length + 1];
    Arrays.fill(res, '0');
    for (int i = res.length - 1, n1Index = n1.length - 1, carry = 0; i >= 0 || n1Index >= 0 || carry != 0; n1Index--, i--) {
      final int a = n1Index >= 0 ? n1[n1Index] - '0' : 0, b = c - '0',
          prod = a * b, sum = prod + carry, ones = sum % 10;
      res[i] = (char) (ones + '0');
      carry = sum / 10;
    }
    return res;
  }
}
