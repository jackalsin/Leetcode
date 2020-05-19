package _0701_0750._738_Monotone_Increasing_Digits;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int monotoneIncreasingDigits(int N) {
    assert N > 0;
    final char[] chars = String.valueOf(N).toCharArray();
    final int n = chars.length;
    int startPoint = n;
    for (int i = chars.length - 1; i > 0; --i) {
      if (chars[i] < chars[i - 1]) {
        startPoint = i;
        chars[i - 1]--;
      }
    }
    for (int i = startPoint; i < n; ++i) {
      chars[i] = '9';
    }
    return Integer.parseInt(String.valueOf(chars));
  }
}
