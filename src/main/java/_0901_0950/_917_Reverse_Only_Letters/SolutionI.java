package _0901_0950._917_Reverse_Only_Letters;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String reverseOnlyLetters(String S) {
    final char[] chars = S.toCharArray();
    final int n = S.length();
    for (int i = 0, j = n - 1; i < j; ) {
      while (i < j && !Character.isLetter(chars[i])) ++i;
      while (i < j && !Character.isLetter(chars[j])) --j;
      if (i < j) {
        swap(chars, i, j);
        ++i;
        --j;
      }
    }
    return String.valueOf(chars);
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
