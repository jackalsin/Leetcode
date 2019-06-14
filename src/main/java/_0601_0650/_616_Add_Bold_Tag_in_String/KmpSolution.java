package _0601_0650._616_Add_Bold_Tag_in_String;

import java.util.Arrays;

public final class KmpSolution implements Solution {
  private static final String BOLD_START = "<b>", BOLD_END = "</b>";

  public String addBoldTag(String s, String[] dict) {
    final boolean[] isBold = new boolean[s.length()];
    for (String word : dict) {
      substring2(s, word, isBold);
      System.out.println(word + ": " + Arrays.toString(isBold));
    }

    final StringBuilder sb = new StringBuilder();
    for (int end = 0; end < s.length(); end++) {
      if (isBold[end]) {
        sb.append(BOLD_START).append(s.charAt(end));
        while (end + 1 < s.length() && isBold[end + 1]) {
          sb.append(s.charAt(end + 1));
          end++;
        }
        sb.append(BOLD_END);
      } else {
        sb.append(s.charAt(end));
      }
    }
    return sb.toString();
  }

  private void substring(final String s, final String p, final boolean[] isBold) {
    final int[] next = preprocessKMP(p);
    //Do the kmp search for the pattern word in s
    int idx = 0;
    int last = -1;
    for (int i = 0; i < s.length(); i++) {
      if (p.charAt(idx) == s.charAt(i)) {
        idx++;
      } else {
        while ((idx > 0) && (s.charAt(i) != p.charAt(idx))) {
          idx = next[idx - 1];
        }
        if (p.charAt(idx) == s.charAt(i)) {
          idx++;
        }
      }
      if (idx == next.length) {
        int start = Math.max(last + 1, i - next.length + 1);
        Arrays.fill(isBold, start, i + 1, true);
        last = i;
        idx = next[idx - 1];
      }
    }
  }

  private void substring2(final String s, final String p, final boolean[] isBold) {
    final int[] next = getNext(p);
    final int sLen = s.length(), pLen = p.length();
    int nextStart = 0;
    int i = 0, j = 0;
    while (i < sLen && j < pLen) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        // when mismatch
        ++i;
        ++j;
      } else {
        // when match
        j = next[j];
      }

      if (j == pLen) {
        final int start = Math.max(nextStart, i - j);
        Arrays.fill(isBold, start, i, true);
        nextStart = i;
        i--;
        j = next[j - 1]; // check the next table, infer from there
      }
    }
  }

  static int[] getNext(final String pattern) {
    final int[] next = new int[pattern.length()];
    if (pattern.isEmpty()) {
      return next;
    }
    Arrays.fill(next, -1);
    int k = -1, j = 0;
    while (j < pattern.length() - 1) {
      if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
        ++k;
        ++j;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

  static int[] preprocessKMP(String p) {
    final int[] ret = new int[p.length()];//ret[i] means the longest proper prefix that is also a suffix in p[0...i]
    for (int i = 1; i < p.length(); i++) {
      int len = ret[i - 1];
      while ((len > 0) && (p.charAt(i) != p.charAt(len))) {
        len = ret[len - 1];
      }
      if (p.charAt(i) == p.charAt(len)) {
        ret[i] = len + 1;
      }//else ret[i] == 0
    }
    return ret;
  }
}
