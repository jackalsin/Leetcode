package pinterest._811_Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=381271&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    final Map<String, Integer> domains = new HashMap<>();
    for (final String cp : cpdomains) {
      final String[] entry = cp.split(" ");
      final int times = Integer.parseInt(entry[0]);
      final String domain = entry[1];
      for (int i = 0; i < entry[1].length(); i++) {
        if (i == 0 || domain.charAt(i) == '.') {
          final int startIndex = i == 0 ? 0 : i + 1;
          final String subdomain = entry[1].substring(startIndex);
          domains.put(subdomain, domains.getOrDefault(subdomain, 0) + times);
        }
      }
    }
    final List<String> result = new ArrayList<>();
    for (final Map.Entry<String, Integer> entry : domains.entrySet()) {
      result.add(entry.getValue() + " " + entry.getKey());
    }
    return result;
  }
}
