package _0801_0850._831_Masking_Personal_Information;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String maskPII(String S) {
    if (S.contains("@")) {
      return getPrivateEmail(S);
    } else {
      return getPrivatePhoneNumber(S);
    }
  }

  private static String getPrivateEmail(final String str) {
    final String[] items = str.split("@");
    final String username = items[0],
        privateUsername = Character.toLowerCase(username.charAt(0))
            + "*".repeat(5) +
            Character.toLowerCase(username.charAt(username.length() - 1));
    return privateUsername + "@" + items[1].toLowerCase();
  }

  private static String getPrivatePhoneNumber(final String phone) {
    final int n = phone.length();
    final StringBuilder str = new StringBuilder();
    for (int i = n - 1; i >= 0; --i) {
      final char chr = phone.charAt(i);
      if (Character.isDigit(chr)) {
        str.append(chr);
      }
    }
    final String last4 = new StringBuilder(str.substring(0, 4)).reverse().toString();
    final int countryCodeLen = str.length() - 10;
    return ((countryCodeLen == 0 ? "" : ("+" + "*".repeat(countryCodeLen)) + "-"))
        + ("***-***-" + last4);
  }
}
