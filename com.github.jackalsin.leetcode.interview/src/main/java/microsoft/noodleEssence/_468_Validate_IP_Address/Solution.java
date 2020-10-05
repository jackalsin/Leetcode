package microsoft.noodleEssence._468_Validate_IP_Address;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";
  private static final Set<Character> VALID_HEX = new HashSet<>();

  static {
    for (char chr = '0'; chr <= '9'; chr++) {
      VALID_HEX.add(chr);
    }
    for (char chr = 'a'; chr <= 'f'; chr++) {
      VALID_HEX.add(chr);
    }
    for (char chr = 'A'; chr <= 'F'; chr++) {
      VALID_HEX.add(chr);
    }
  }

  public String validIPAddress(String IP) {
    if (IP == null) {
      return NEITHER;
    }
    if (IP.contains(".")) {
      return (IP.charAt(IP.length() - 1) != '.' && ipv4Validate(IP)) ? IPV4 : NEITHER;
    } else if (IP.contains(":")) {
      return (IP.charAt(IP.length() - 1) != ':' && ipv6Validate(IP)) ? IPV6 : NEITHER;
    }
    return NEITHER;
  }

  private static boolean ipv4Validate(String ip) {
    final String[] items = ip.split("\\.");
    if (items.length != 4) {
      return false;
    }
    for (String item : items) {
      int num = 0;
      if (item.length() == 0 || item.length() > 3) {
        return false;
      }
      if (item.length() == 2 || item.length() == 3) {
        if (item.charAt(0) == '0') {
          return false;
        }
      }
      for (char chr : item.toCharArray()) {
        if (!Character.isDigit(chr)) {
          return false;
        }
        num = num * 10 + chr - '0';
      }
      if (num >= 256) {
        return false;
      }
    }
    return true;
  }

  private static boolean ipv6Validate(String ip) {
    final String[] items = ip.split(":");
    if (items.length != 8) {
      return false;
    }
    for (String item : items) {
      if (item.length() == 0 || item.length() > 4) {
        return false;
      }

      for (char chr : item.toCharArray()) {
        if (!VALID_HEX.contains(chr)) {
          return false;
        }
      }
    }
    return true;
  }
}
