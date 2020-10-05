package hulu._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    final int n1 = num1.length(), n2 = num2.length();
    final char[] chars = new char[Math.max(n1, n2) + 1];
    int carry = 0;
    for (int i = n1 - 1, j = n2 - 1, k = chars.length - 1;
         k >= 0; k--, i--, j--) {
      final int a = i < 0 ? 0 : num1.charAt(i) - '0',
          b = j < 0 ? 0 : num2.charAt(j) - '0', sum = carry + a + b;
      carry = sum / 10;
      chars[k] = (char) (sum % 10 + '0');
    }
    final String candidate = String.valueOf(chars);
    return candidate.charAt(0) == '0' ? candidate.substring(1) : candidate;
  }
}
