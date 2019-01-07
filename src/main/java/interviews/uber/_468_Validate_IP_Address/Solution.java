package interviews.uber._468_Validate_IP_Address;

public class Solution {
  static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";

  public String validIPAddress(String IP) {
    if (IP.contains(".")) {
      return validIpv4(IP) ? IPV4 : NEITHER;
    } else if (IP.contains(":")) {
      return validIpv6(IP) ? IPV6 : NEITHER;
    } else {
      return NEITHER;
    }
  }

  private static boolean validIpv6(final String ip) {
    if (ip.endsWith(":")) {
      return false;
    }
    final String[] input = ip.split(":");
    if (input.length != 8) {
      return false;
    }
    for (String ipSect : input) {
      if (ipSect.length() == 0 || ipSect.length() > 4) {
        return false;
      }
      for (char chr : ipSect.toCharArray()) {
        chr = Character.toLowerCase(chr);
        if (!Character.isDigit(chr) && (chr < 'a' || chr > 'f')) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean validIpv4(final String ip) {
    if (ip.endsWith(".")) {
      return false;
    }
    final String[] input = ip.split("\\.");
    if (input.length != 4) {
      return false;
    }
    for (String ipSect : input) {
      if (ipSect.length() > 3 || ipSect.length() == 0) {
        return false;
      }
      if (ipSect.length() > 1 && ipSect.charAt(0) == '0') {
        return false;
      }
      int tmp = 0;
      for (char chr : ipSect.toCharArray()) {
        if (!Character.isDigit(chr)) return false;
        tmp = tmp * 10 + chr - '0';
      }
      if (tmp >= 256) {
        return false;
      }
    }
    return true;
  }
}
