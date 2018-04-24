package _451_500._468_Validate_IP_Address;

public class Solution {
  static final String IPV4 = "IPv4", IPV6 = "IPv6", NEITHER = "Neither";

  public String validIPAddress(String IP) {
    if (IP.contains(".")) {
      return (IP.charAt(IP.length() - 1) != '.' && isIPV4(IP.split("\\."))) ? IPV4 : NEITHER;
    } else if (IP.contains(":")) {
      return (IP.charAt(IP.length() - 1) != ':' && isIPV6(IP.split(":"))) ? IPV6 : NEITHER;
    } else {
      return NEITHER;
    }
  }

  /**
   * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
   * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
   * one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the
   * address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros
   * and using upper cases).
   * <p>
   * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons
   * (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
   * <p>
   * Leading zero is invalid
   *
   * @param ip
   * @return
   */
  private boolean isIPV6(String[] ip) {
    if (ip.length == 8) {
      for (String ipSec : ip) {
        if (!isValidIPv6Section(ipSec)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  private static boolean isValidIPv6Section(String ipSec) {
    if (ipSec.length() == 0) {
      return false;
    } else if (ipSec.length() == 1) {
      return isHexChar(ipSec.charAt(0));
    } else if (ipSec.length() <= 4) {
      for (char chr : ipSec.toCharArray()) {
        if (!isHexChar(chr)) {
          return false;
        }
      }
      final int val = Integer.valueOf(ipSec, 16);
      return val < 0xffff;
    } else {
      return false;
    }
  }

  private static boolean isHexChar(final char chr) {
    return Character.isDigit(chr) || (chr <= 'f' && chr >= 'a') || (chr <= 'F' && chr >= 'A');
  }

  /**
   * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
   * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
   *
   * @param ip
   * @return
   */
  private boolean isIPV4(String[] ip) {
    if (ip.length == 4) {
      for (int i = 0; i < ip.length; i++) {
        if (!isValidIPV4(ip[i])) {
          System.out.println(ip[i]);
          return false;
        }
      }
      return true;
    }
    // not 4 section
    return false;
  }


  /**
   * Return true when ipSection is between 0 ~ 255 (both inclusive)
   *
   * @param ipSection
   * @return
   */
  private static boolean isValidIPV4(final String ipSection) {
    if (ipSection.length() == 0) {
      return false;
    } else if (ipSection.length() == 1) {
      return Character.isDigit(ipSection.charAt(0));
    } else if (ipSection.length() <= 3) {
      if (ipSection.charAt(0) == '0') {
        return false;
      }
      int num = 0;
      for (char chr : ipSection.toCharArray()) {
        if (!Character.isDigit(chr)) {
          return false;
        }
        num = num * 10 + chr - '0';
      }
      return num < 256;
    } else {
      return false;
    }
  }
}
