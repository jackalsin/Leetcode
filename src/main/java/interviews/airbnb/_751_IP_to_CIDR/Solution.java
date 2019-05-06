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
      final int rightMost = (ipNum & (-ipNum));
      int submask = 32, count = 1;
      while (count <= n && count <= rightMost) {
        count *= 2;
        submask--;
      }
      count /= 2;
      submask++;
      n -= count;
      result.add(get(ipNum) + "/" + submask);
      ipNum += count;
    }
    return result;
  }

  private static String get(final int ip) {
    return String.format("%s.%s.%s.%s",
        ip >>> 24,
        (ip << 8) >>> 24,
        (ip << 16) >>> 24,
        (ip << 24) >>> 24);
  }

  private static int get(final String ip) {
    int num = 0;
    final String[] items = ip.split("\\.");
    for (String item : items) {
      num = (num << 8) | Integer.valueOf(item);
    }
    return num;
  }
}
