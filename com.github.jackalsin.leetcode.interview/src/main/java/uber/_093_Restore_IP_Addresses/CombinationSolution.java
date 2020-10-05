package uber._093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
public final class CombinationSolution implements Solution {
  @Override
  public List<String> restoreIpAddresses(String s) {
    final List<String> result = new ArrayList<>();
    for (int a = 1; a <= 3; a++) {
      for (int b = 1; b <= 3; b++) {
        for (int c = 1; c <= 3; ++c) {
          for (int d = 1; d <= 3; ++d) {
            if (a + b + c + d != s.length()) continue;
            final int num1 = Integer.parseInt(s.substring(0, a)),
                num2 = Integer.parseInt(s.substring(a, a + b)),
                num3 = Integer.parseInt(s.substring(a + b, a + b + c)),
                num4 = Integer.parseInt(s.substring(a + b + c));
            if (num1 < 256 && num2 < 256 && num3 < 256 && num4 < 256) {
              final String candidate =
                  new StringBuilder().append(num1).append(".").append(num2).append(".").append(num3)
                      .append(".").append(num4).toString();
              if (candidate.length() == s.length() + 3) {
                result.add(candidate);
              }
            }
          }
        }
      }
    }
    return result;
  }
}
