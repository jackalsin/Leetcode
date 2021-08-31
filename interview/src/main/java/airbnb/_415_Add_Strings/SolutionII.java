package airbnb._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 8/30/2021
 */
public final class SolutionII implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    final int n1 = num1.length(), n2 = num2.length();
    final StringBuilder sb = new StringBuilder();
    for (int i = n1 - 1, j = n2 - 1, carry = 0;
         i >= 0 || j >= 0 || carry != 0; --i, --j) {
      final int a = i < 0 ? 0 : num1.charAt(i) - '0',
          b = j < 0 ? 0 : num2.charAt(j) - '0',
          sum = a + b + carry,
          d = sum % 10;
      carry = sum / 10;
      sb.append(d);
    }

    return sb.length() == 0 ? "0" : sb.reverse().toString();
  }
}
