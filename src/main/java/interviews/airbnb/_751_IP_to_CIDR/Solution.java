package interviews.airbnb._751_IP_to_CIDR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/5/2019.
 */
public final class Solution {

  public List<String> ipToCIDR(String ip, int n) {
    long ipL = getLongFromIp(ip);

    final List<String> result = new ArrayList<>();
    while (n > 0) {
      int step = (int) (ipL & (-ipL)); // most significant
      while (step > n) step /= 2;

      int submask = 32;
      for (int i = 1; i < step; i *= 2) {
        submask--;
      }
      result.add(getIpString(ipL) + "/" + submask);
      n -= step;
      ipL += step;
    }
    return result;
  }

  private static String getIpString(final long ip) {
    return String.format("%s.%s.%s.%s", ip >>> 24, (ip >>> 16) % 256, (ip >>> 8) % 256, ip % 256);
  }

  private static long getLongFromIp(String ip) {
    final String[] items = ip.split("\\.");
    long res = 0;
    for (String item : items) {
      res = res * 256 + Integer.parseInt(item);
    }
    return res;
  }
}
