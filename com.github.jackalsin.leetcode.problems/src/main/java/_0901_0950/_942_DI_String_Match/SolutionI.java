package _0901_0950._942_DI_String_Match;

/**
 * @author jacka
 * @version 1.0 on 9/26/2020
 */
public final class SolutionI implements Solution {
  private static final char I = 'I', D = 'D';

  public int[] diStringMatch(String S) {
    if (S == null || S.length() == 0) return new int[0];
    final int n = S.length();
    final int[] result = new int[n + 1];
    int left = 0, right = n;
    for (int i = 0; i < n; ++i) {
      final char chr = S.charAt(i);
      if (chr == I) {
        result[i] = left++;
      } else {
        result[i] = right--;
      }
    }
    assert left == right;
    result[n] = left;
    return result;
  }
}
