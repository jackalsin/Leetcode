package _0051_0100._093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class Solution {
  public List<String> restoreIpAddresses(String s) {
    if (s.length() > 12) return new ArrayList<>();
    List<String> result = new ArrayList<>();
    restoreIpAddresses(result, new StringBuilder(), s, 0, 0);
    return result;
  }

  private void restoreIpAddresses(List<String> result, StringBuilder sb,
                                  String s, int startIndex, int partCounts) {
    if (startIndex == s.length()) {
      if (partCounts == 4) {
        result.add(sb.substring(1));
      }
    } else {
      for (int i = 1; i <= 3; i++) {
        if (startIndex + i <= s.length()) {
          // To prevent leading zeros
          String partString = s.substring(startIndex, startIndex + i);
          if (partString.length() > 1 && partString.charAt(0) == '0')
            continue;
          // To prevent leading zeros end
          int part = Integer.parseInt(partString);
          if (part < 256) {
            int preSize = sb.length();
            sb.append(".").append(s.substring(startIndex, startIndex + i));
            restoreIpAddresses(result, sb, s, startIndex + i, partCounts + 1);
            sb.delete(preSize, sb.length());
          }
        }
      }
    }
  }
}
