package linkedin._468_Validate_IP_Address;

public final class SolutionI implements Solution {
  static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";

  public String validIPAddress(String IP) {
    if (IP == null) {
      return NEITHER;
    } else if (IP.contains(".")) {
      if (IP.endsWith(".")) {
        return NEITHER;
      }
      return isValidIPv4(IP);
    } else if (IP.contains(":")) {
      if (IP.endsWith(":")) {
        return NEITHER;
      }
      return isValidIPv6(IP);
    } else {
      return NEITHER;
    }
  }

  private static String isValidIPv6(String ip) {
    final String[] ipArray = ip.split(":");
    if (ipArray.length != 8) {
      return NEITHER;
    }
    for (final String sec : ipArray) {
      if (sec.length() == 0 || sec.length() > 4) {
        return NEITHER;
      }
      for (char chr : sec.toCharArray()) {
        chr = Character.toLowerCase(chr);
        if (!Character.isDigit(chr) && !(chr <= 'f' && chr >= 'a')) {
          return NEITHER;
        }
      }
    }
    return IPV6;
  }

  private static String isValidIPv4(String ip) {
    final String[] ipArray = ip.split("\\.");
    if (ipArray.length != 4) {
      return NEITHER;
    }

    for (final String sec : ipArray) {
      if (sec.length() > 3 || sec.length() == 0) {
        return NEITHER;
      }

      if (sec.length() > 1 && sec.startsWith("0")) {
        return NEITHER;
      }
      int sum = 0;
      for (char chr : sec.toCharArray()) {
        if (!Character.isDigit(chr)) {
          return NEITHER;
        }
        sum = sum * 10 + chr - '0';
      }
      if (sum >= 256) {
        return NEITHER;
      }
    }
    return IPV4;
  }
}
