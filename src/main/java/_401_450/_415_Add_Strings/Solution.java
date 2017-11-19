package _401_450._415_Add_Strings;

public class Solution {
  public String addStrings(String num1, String num2) {
    final int len = Math.max(num1.length(), num2.length()) + 1;
    final char[] result = new char[len];
    int carry = 0;
    for (int i = 0; i < len; i++) {
      int num1Val = i < num1.length() ? (num1.charAt(num1.length() - 1 - i) - '0') : 0,
          num2Val = i < num2.length() ? (num2.charAt(num2.length() - 1 - i) - '0') : 0,
          sum = num1Val + num2Val + carry, curDigit = sum % 10;
      carry = sum / 10;
      result[len - i - 1] = (char) (curDigit + '0');
    }
    final StringBuilder sb = new StringBuilder().append(result);
    return result[0] == '0' && len != 1 ? sb.substring(1) : sb.toString();
  }

}
