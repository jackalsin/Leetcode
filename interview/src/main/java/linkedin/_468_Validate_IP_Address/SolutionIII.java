package linkedin._468_Validate_IP_Address;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
public final class SolutionIII implements Solution {
  private static final String NEITHER = "Neither",
      IPV4 = "IPv4", IPV6 = "IPv6";

  public String validIPAddress(String IP) {
    if (IP == null) {
      return NEITHER;
    } else if (IP.contains(".") && !IP.endsWith(".") && isIPv4(IP)) {
      return IPV4;
    } else if (IP.contains(":") && !IP.endsWith(":") && isIPv6(IP)) {
      return IPV6;
    } else {
      return NEITHER;
    }
  }

  private static boolean isIPv4(final String ip) {
    final String[] items = ip.split("\\.");
    if (items.length != 4) {
      return false;
    }
    for (final String item : items) {
      if (item.isEmpty() || item.length() > 4) {
        return false;
      }
      int cur = 0;
      final char[] chars = item.toCharArray();
      if (chars.length != 1 && chars[0] == '0') {
        return false;
      }
      for (final char chr : chars) {
        if (!Character.isDigit(chr)) return false;
        cur = cur * 10 + chr - '0';
      }
      if (cur >= 256) {
        return false;
      }
    }
    return true;
  }

  private static boolean isIPv6(final String ip) {
    final String[] items = ip.split(":");
    if (items.length != 8) {
      return false;
    }
    for (final String item : items) {
      if (item.length() == 0 || item.length() > 4) { // ipv 6
        return false;
      }
      for (final char chr : item.toCharArray()) {
        if (!isHex(chr)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isHex(final char chr) {
    if (Character.isDigit(chr)) {
      return true;
    }
    final char normalizedChr = Character.toLowerCase(chr);
    return 'a' <= normalizedChr && normalizedChr <= 'f';
  }
}
