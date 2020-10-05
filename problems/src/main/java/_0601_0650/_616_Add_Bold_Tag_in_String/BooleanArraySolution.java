package _0601_0650._616_Add_Bold_Tag_in_String;

import java.util.Arrays;

public class BooleanArraySolution implements Solution {

  private static final String BOLD_START = "<b>", BOLD_END = "</b>";

  public String addBoldTag(String s, String[] dict) {
    if (s == null) {
      return s;
    }
    final boolean[] isBold = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (String w : dict) {
        if (s.startsWith(w, i)) {
          Arrays.fill(isBold, i, i + w.length(), true);
        }
      }
    }

    final StringBuilder sb = new StringBuilder();
    for (int end = 0; end < s.length(); end++) {
      if (isBold[end]) {
        sb.append(BOLD_START).append(s.charAt(end));
        while (end + 1 < isBold.length && isBold[end + 1]) {
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
}
