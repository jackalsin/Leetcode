package _0801_0850._848_Shifting_Letters;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String shiftingLetters(String S, int[] shifts) {
    final char[] chars = S.toCharArray();
    final int n = shifts.length;
    for (int i = n - 1; i >= 1; --i) {
      shifts[i - 1] = (shifts[i - 1] + shifts[i]) % 26;
    }
    for (int i = 0; i < shifts.length; ++i) {
      shift(chars, i, shifts[i]);
    }
    return String.valueOf(chars);
  }

  private static void shift(final char[] chars, final int i, final int shift) {
    chars[i] = (char) (((chars[i] - 'a') + shift) % 26 + 'a');
  }
}
