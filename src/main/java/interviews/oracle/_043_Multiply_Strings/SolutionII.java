package interviews.oracle._043_Multiply_Strings;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/31/2019
 */
public final class SolutionII implements Solution {
  @Override
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null) {
      return null;
    }
    final int m = num1.length(), n = num2.length();
    final int[] nums = new int[m + n];
    for (int i = m - 1; i >= 0; --i) {
      for (int j = n - 1; j >= 0; --j) {
        final int n1 = num1.charAt(i) - '0', n2 = num2.charAt(j) - '0',
            sum = n1 * n2 + nums[i + j + 1];
        nums[i + j + 1] = sum % 10;
        nums[i + j] += sum / 10;
      }
    }
    final StringBuilder sb = new StringBuilder();
    boolean isLeadingZero = true;
    for (int num : nums) {
      if (num == 0 && isLeadingZero) {
        continue;
      }
      isLeadingZero = false;
      sb.append(num);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
