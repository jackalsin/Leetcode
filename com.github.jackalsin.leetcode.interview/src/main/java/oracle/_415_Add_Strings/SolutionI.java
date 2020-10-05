package oracle._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/29/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    final int m = num1.length(), n = num2.length(), len = Math.max(n, m) + 1;
    final int[] nums = new int[len];
    for (int i = m - 1, j = n - 1, carry = 0, k = len - 1; i >= 0 || j >= 0 || carry != 0; --i, --j, --k) {
      final int a = i < 0 ? 0 : num1.charAt(i) - '0', b = j < 0 ? 0 : num2.charAt(j) - '0', sum = a + b + carry,
          digit = sum % 10;
      carry = sum / 10;
      nums[k] = digit;
    }
    final StringBuilder sb = new StringBuilder();
    int start = 0;
    while (start < nums.length) {
      if (nums[start] != 0) break;
      start++;
    }
    for (int i = start; i < nums.length; ++i) {
      sb.append(nums[i]);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
