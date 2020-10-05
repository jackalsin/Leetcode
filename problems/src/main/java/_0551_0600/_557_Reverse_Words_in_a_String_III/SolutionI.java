package _0551_0600._557_Reverse_Words_in_a_String_III;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {

  @Override
  public String reverseWords(String s) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == ' ') {
        sb.append(chr);
      } else {
        final int start = i;
        while (i + 1 < s.length() && s.charAt(i + 1) != ' ') {
          i++;
        }
        for (int k = i; k >= start; k--) {
          sb.append(s.charAt(k));
        }
      }
    }
    return sb.toString();
  }
}
