package interviews.linkedin._468_Validate_IP_Address;

public class Solution { // TODO: Revisit
  static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";

  public String validIPAddress(String IP) {
    if (IP == null) {
      return NEITHER;
    }

    if (!IP.endsWith(".") && IP.contains(".")) {
      return ipv4Validate(IP);
    } else if (!IP.endsWith(":") && IP.contains(":")) {
      return ipv6Validate(IP);
    } else {
      return NEITHER;
    }
  }

  private static String ipv6Validate(String ip) {
    final String[] items = ip.split(":");
    if (items.length != 8) {
      return NEITHER;
    }
    for (String item : items) {
      if (item.length() > 4 || item.length() == 0) {
        return NEITHER;
      }
      for (char chr : item.toCharArray()) {
        if (!Character.isDigit(chr) &&
            !('a' <= Character.toLowerCase(chr) && Character.toLowerCase(chr) <= 'f')
        ) {
          return NEITHER;
        }
      }
    }
    return IPV6;
  }

  private static String ipv4Validate(String ip) {
    final String[] items = ip.split("\\.");
    if (items.length != 4) {
      return NEITHER;
    }
    for (String item : items) {
      if (item.length() == 0 || item.length() > 3) {
        return NEITHER;
      }
      int i = 0;
      for (char chr : item.toCharArray()) {
        if (Character.isDigit(chr)) {
          i = i * 10 + chr - '0';
        } else {
          return NEITHER;
        }
      } // end of loop char
      if (i > 255) {
        return NEITHER;
      }
      if (item.length() > 1 && item.charAt(0) == '0') {
        return NEITHER;
      }
    }
    return IPV4;
  }
}
