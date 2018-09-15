package _751_800._796_Rotate_String;

public final class KmpSolution implements Solution {
  @Override
  public boolean rotateString(String A, String B) {
    final String s = A + A, p = B;
    final int[] next = getNext(p);

    for (int i = 0, j = 0; i < s.length() && j < p.length(); ) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        ++i;
        ++j;
        if (j == p.length()) {
          return true;
        }
      } else {
        j = next[j];
      }
    }
    return false;
  }

  static int[] getNext(final String p) {
    final int[] next = new int[p.length()];
    next[0] = -1;
    for (int k = -1, j = 0; j < p.length() - 1; ) {
      if (k == -1 || p.charAt(k) == p.charAt(j)) {
        k++;
        j++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}
