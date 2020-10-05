package example.string;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
public final class KMPII implements KMP {
  @Override
  public int substring(String s, String p) {
    final int[] next = getNext(p);
    int i = 0, j = 0;
    for (; i < s.length() && j < p.length(); ) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        ++i;
        ++j;
      } else {
        j = next[j];
      }
    }

    if (j == p.length()) {
      return i - j;
    }
    return -1;
  }

  @Override
  public int[] getNext(String p) {
    assert p != null;
    final int n = p.length();
    final int[] next = new int[n];
    if (n == 0) {
      return new int[0];
    }
    next[0] = -1;
    int j = 0, k = -1;
    while (j < p.length() - 1) {
      if (k == -1 || p.charAt(k) == p.charAt(j)) {
        j++;
        k++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}
