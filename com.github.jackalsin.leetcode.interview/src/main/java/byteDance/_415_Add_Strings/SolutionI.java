package byteDance._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    assert num1 != null && num2 != null;
    final int n = num1.length(), m = num2.length();
    final char[] chars = new char[Math.max(n, m) + 1];
    int k = chars.length - 1;
    for (int i = n - 1, j = m - 1, carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j, --k) {
      final int a = i < 0 ? 0 : num1.charAt(i) - '0',
          b = j < 0 ? 0 : num2.charAt(j) - '0', sum = a + b + carry,
          d = sum % 10;
      carry = sum / 10;
      chars[k] = (char) (d + '0');
    }
    return String.valueOf(chars).substring(k + 1);
  }
}
