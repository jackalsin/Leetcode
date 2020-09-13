package _0851_0900._868_Binary_Gap;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int binaryGap(int N) {
    final String str = Integer.toBinaryString(N);
    int max = 0, prev = -1;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == '1') {
        if (prev != -1) {
          max = Math.max(i - prev, max);
        }
        prev = i;
      }
    }
    return max;
  }
}
