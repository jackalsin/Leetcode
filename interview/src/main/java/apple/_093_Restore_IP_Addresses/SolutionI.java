package apple._093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/24/2021
 */
public final class SolutionI implements Solution {
  private static final String DOT = ".";

  public List<String> restoreIpAddresses(String s) {
    final List<String> result = new ArrayList<>();
    for (int i = 1; i <= 3; ++i) {
      for (int j = 1; j <= 3; ++j) {
        for (int k = 1; k <= 3; ++k) {
          for (int l = 1; l <= 3; ++l) {
            if (i + j + k + l != s.length()) continue;
            final int first = Integer.parseInt(s.substring(0, i)),
                second = Integer.parseInt(s.substring(i, i + j)),
                third = Integer.parseInt(s.substring(i + j, i + j + k)),
                fourth = Integer.parseInt(s.substring(i + j + k));
            if (first >= 256 || second >= 256 || third >= 256 || fourth >= 256) {
              continue;
            }
            final String candidate = new StringBuilder().append(first).
                append(DOT).append(second).append(DOT).append(third).append(DOT).
                append(fourth).toString();
            if (candidate.length() == s.length() + 3) {
              result.add(candidate);
            }
          }
        }
      }
    }
    return result;
  }

}
