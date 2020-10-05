package linkedin._468_Validate_IP_Address;

public final class SolutionII implements Solution {
  static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";

  public String validIPAddress(String IP) {
    if (IP.contains(".")) {
      if (IP.endsWith(".")) return NEITHER;
      return isValidIpv4(IP);
    } else if (IP.contains(":")) {
      if (IP.endsWith(":")) return NEITHER;
      return isValidIpv6(IP);
    } else {
      return NEITHER;
    }
  }

  private static String isValidIpv6(final String ip) {
    final String[] ipEntries = ip.split(":");
    if (ipEntries.length != 8) {
      return NEITHER;
    }
    for (String sec : ipEntries) {
      if (sec.length() == 0 || sec.length() > 4) {
        return NEITHER;
      }
      final String secLower = sec.toLowerCase();
      for (char chr : secLower.toCharArray()) {
        if (Character.isDigit(chr)) continue;
        if ('a' > chr || chr > 'f') {
          return NEITHER;
        }
      }
    }
    return IPV6;
  }

  private static String isValidIpv4(final String ip) {
    final String[] ipEntries = ip.split("\\.");
    if (ipEntries.length != 4) {
      return NEITHER;
    }
    for (String sec : ipEntries) {
      if (sec.length() == 0 || sec.length() > 3) {
        return NEITHER;
      }
      if (sec.charAt(0) == '0' && sec.length() != 1) {
        return NEITHER;
      }
      int num = 0;
      for (char chr : sec.toCharArray()) {
        if (!Character.isDigit(chr)) {
          return NEITHER;
        }
        num = num * 10 + chr - '0';
      }
      if (num > 255) {
        return NEITHER;
      }
    }
    return IPV4;
  }
}
