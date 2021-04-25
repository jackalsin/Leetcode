package google._616_Add_Bold_Tag_in_String;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
public final class BooleanArraySolution implements Solution {
  private static final String LEFT = "<b>", RIGHT = "</b>";

  public String addBoldTag(String s, String[] dict) {
    if (s == null || s.isEmpty()) return s;
    final int n = s.length();
    final boolean[] bold = new boolean[n];

    for (int start = 0; start < n; ++start) {
      for (final String word : dict) {
        if (s.startsWith(word, start)) {
          Arrays.fill(bold, start, word.length() + start, true);
        }
      }
    }

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      if (bold[i] && (i == 0 || !bold[i - 1])) {
        sb.append(LEFT);
      }
      sb.append(s.charAt(i));
      if (bold[i] && (i == n - 1 || !bold[i + 1])) {
        sb.append(RIGHT);
      }
    }

    return sb.toString();
  }

}
