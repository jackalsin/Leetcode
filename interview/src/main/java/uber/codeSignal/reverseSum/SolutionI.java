package uber.codeSignal.reverseSum;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int getReverseSum(int[] nums) {
    int res = 0;
    for (final int num : nums) {
      res += reverse(num);
    }
    return res;
  }

  private static int reverse(final int num) {
    final char[] chars = String.valueOf(num).toCharArray();
    int rightEnd = chars.length - 1;
    while (rightEnd >= 0 && chars[rightEnd] == '0') {
      --rightEnd;
    }
    for (int left = 0, right = rightEnd; left < right; left++, --right) {
      final char tmp = chars[left];
      chars[left] = chars[right];
      chars[right] = tmp;
    }
    return Integer.parseInt(String.valueOf(chars));
  }
}
