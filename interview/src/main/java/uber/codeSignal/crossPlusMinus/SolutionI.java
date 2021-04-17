package uber.codeSignal.crossPlusMinus;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int calculate(int num) {
    final char[] chars = String.valueOf(num).toCharArray();
    int res = 0;
    for (int i = 0, sign = 1; i < chars.length; ++i, sign *= -1) {
      res += sign * (chars[i] - '0');
    }
    return res;
  }
}
