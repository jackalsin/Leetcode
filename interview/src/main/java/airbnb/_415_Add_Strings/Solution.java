package airbnb._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 2/9/2019.
 */
public class Solution {
  public String addStrings(String num1, String num2) {
    assert num1.length() > 0 && num2.length() > 0;
    final char[] chr1 = num1.toCharArray(), chr2 = num2.toCharArray();
    final char[] res = new char[Math.max(num1.length(), num2.length()) + 1];
    for (int i = chr1.length - 1, j = chr2.length - 1, resIndex = res.length - 1, carry = 0;
         i >= 0 || j >= 0 || resIndex >= 0 || carry > 0
        ; i--, j--, resIndex--) {
      final int one = i >= 0 ? chr1[i] - '0' : 0, other = j >= 0 ? chr2[j] - '0' : 0,
          sum = one + other + carry, cur = sum % 10;
      carry = sum / 10;
      res[resIndex] = (char) (cur + '0');
    }

    return res[0] == '0' ? String.valueOf(res, 1, res.length - 1) : String.valueOf(res);
  }
}
