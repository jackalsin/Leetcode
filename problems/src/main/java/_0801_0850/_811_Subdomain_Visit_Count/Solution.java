package _0801_0850._811_Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    final Map<String, Integer> domains = new HashMap<>();
    for (String cp : cpdomains) {
      final String[] cpArray = cp.split(" ");
      final int count = Integer.parseInt(cpArray[0]);
      final String domain = cpArray[1];
      for (int i = domain.length() - 1; i >= 0; i--) {
        if (i == 0 || domain.charAt(i - 1) == '.') {
          final String curDomain = domain.substring(i);
          domains.put(curDomain, domains.getOrDefault(curDomain, 0) + count);
        }
      }
    }
    // get result format.
    final List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : domains.entrySet()) {
      result.add(entry.getValue() + " " + entry.getKey());
    }
    return result;
  }

}
