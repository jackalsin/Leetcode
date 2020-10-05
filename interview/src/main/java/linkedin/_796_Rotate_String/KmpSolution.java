package linkedin._796_Rotate_String;

public final class KmpSolution implements Solution {

  @Override
  public boolean rotateString(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    final String s = A + A, p = B;
    final int[] next = getNext(p);
    int i = 0, j = 0;
    for (; i < s.length() && j < p.length(); ) {
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
    return j == p.length();
  }

  static int[] getNext(final String p) {
    final int[] next = new int[p.length()];
    if (p.length() == 0) {
      return next;
    }
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
