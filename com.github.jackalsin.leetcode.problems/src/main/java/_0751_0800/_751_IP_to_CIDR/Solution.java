package _0751_0800._751_IP_to_CIDR;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> ipToCIDR(String ip, int n) {
    long ipL = stringToLong(ip);
    final List<String> result = new ArrayList<>();
    while (n > 0) {
      int step = (int) (ipL & (-ipL)); // most significant
      while (step > n) step /= 2;
      int submask = 32;
      for (int i = 1; i < step; i *= 2) {
        submask--;
      }

      String curIp = getIp(ipL);
      result.add(curIp + "/" + submask);

      ipL += step;
      n -= step;
    }
    return result;
  }

  private static String getIp(long ipL) {
    return String.format("%s.%s.%s.%s", (ipL >>> 24), (ipL >>> 16) % 256, (ipL >>> 8) % 256, ipL % 256);
  }

  private static long stringToLong(String ip) {
    long res = 0;
    final String[] ips = ip.split("\\.");
    for (String sec : ips) {
      res = res * 256 + Integer.parseInt(sec);
    }
    return res;
  }
}
