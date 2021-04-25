package _0601_0650._616_Add_Bold_Tag_in_String;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
public final class OnePassSolution implements Solution {
  private static final String LEFT = "<b>", RIGHT = "</b>";

  public String addBoldTag(String s, String[] dict) {
    int boldUntil = -1;
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      for (final String word : dict) {
        if (s.startsWith(word, i)) {
          if (boldUntil < i) sb.append(LEFT);
          boldUntil = Math.max(boldUntil, i + word.length());
        }
      }
      if (i == boldUntil) sb.append(RIGHT);
      sb.append(s.charAt(i));
    }
    if (boldUntil == s.length()) sb.append(RIGHT);
    return sb.toString();
  }
}
