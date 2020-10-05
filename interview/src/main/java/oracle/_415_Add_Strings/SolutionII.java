package oracle._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionII implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    final int m = num1.length(), n = num2.length();
    final char[] chars = new char[Math.max(n, m) + 1];
    for (int i = m - 1, j = n - 1, k = chars.length - 1, carry = 0; k >= 0; --i, --j, --k) {
      final int a = i >= 0 ? num1.charAt(i) - '0' : 0,
          b = j >= 0 ? num2.charAt(j) - '0' : 0,
          sum = a + b + carry,
          cur = sum % 10;
      carry = sum / 10;
      chars[k] = (char) (cur + '0');
    }
    final String str = String.valueOf(chars);
    return str.length() == 0 ? "0" : (str.charAt(0) == '0' ? str.substring(1) : str);
  }
}
