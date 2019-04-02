package interviews.airbnb._751_IP_to_CIDR;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/5/2019.
 */
public final class Solution {

  public List<String> ipToCIDR(String ip, int n) {
    int ipNum = get(ip);
    final List<String> result = new ArrayList<>();
    while (n > 0) {
      int step = ipNum & (-ipNum);
      while (step > n) step /= 2;
      int submask = 32;
      for (int i = 1; i < step; i *= 2) {
        submask--;
      }

      final String ipStr = get(ipNum);
      result.add(ipStr + "/" + submask);
      ipNum += step;
      n -= step;
    }
    return result;
  }

  private static String get(int ip) {
    return String.format("%d.%d.%d.%d",
        (ip >>> 24), ((ip << 8) >>> 24), ((ip << 16) >>> 24), ((ip << 24) >>> 24)
    );
  }

  private static int get(String ip) {
    int res = 0;
    final String[] ips = ip.split("\\.");
    for (String sec : ips) {
      res = res * 256 + Integer.parseInt(sec);
    }
    return res;
  }
}
