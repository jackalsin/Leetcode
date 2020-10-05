package google._482_License_Key_Formatting;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public final class SolutionI implements Solution {
  private static final char DASH = '-';

  public String licenseKeyFormatting(String S, int K) {
    final StringBuilder sb = new StringBuilder();
    for (int i = S.length() - 1; i >= 0; --i) {
      final char chr = Character.toUpperCase(S.charAt(i));
      if (chr == DASH) {
        continue;
      }
      sb.append(chr);
      if (sb.length() % (K + 1) == K) {
        sb.append(DASH);
      }
    }
    final int len = sb.length() - 1;
    if (sb.length() > 0 && sb.charAt(len) == DASH) {
      sb.setLength(len);
    }
    return sb.reverse().toString();
  }
}
