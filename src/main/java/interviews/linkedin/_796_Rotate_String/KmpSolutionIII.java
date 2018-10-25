package interviews.linkedin._796_Rotate_String;

public final class KmpSolutionIII implements Solution {

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
        i++;
        j++;

      } else {
        j = next[j];
      }
    }
    return j == p.length();
  }

  private static int[] getNext(final String p) {
    final int[] next = new int[p.length()];
    if (p.length() == 0) {
      return next;
    }
    next[0] = -1;
    for (int i = 0, k = -1; i < p.length() - 1; ) {
      if (k == -1 || p.charAt(i) == p.charAt(k)) {
        k++;
        i++;
        next[i] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}
