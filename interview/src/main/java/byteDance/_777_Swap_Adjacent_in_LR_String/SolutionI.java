package byteDance._777_Swap_Adjacent_in_LR_String;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  private static final char X = 'X', L = 'L', R = 'R';

  public boolean canTransform(String start, String end) {
    final int m = start.length(), n = end.length();
    for (int p = 0, q = 0; p <= m && q <= n; ++p, ++q) {
      while (p < m && start.charAt(p) == X) p++;
      while (q < n && end.charAt(q) == X) q++;
      if (p == m && q == n) {
        return true;
      }
      if (p == m || q == n) {
        return false;
      }
      final char sChar = start.charAt(p), eChar = end.charAt(q);
      if (sChar != eChar) return false;
      // l can move left, p >= q
      if (start.charAt(p) == L && p < q) return false;
      if (start.charAt(p) == R && p > q) return false;
    }
    return false;
  }
}
