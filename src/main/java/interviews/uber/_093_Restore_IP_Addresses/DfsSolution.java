package interviews.uber._093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
public final class DfsSolution implements Solution {
  @Override
  public List<String> restoreIpAddresses(String s) {
    final List<String> result = new ArrayList<>();
    restoreIpAddresses(result, new ArrayList<>(), new StringBuilder(), s, 0);
    return result;
  }

  private static void restoreIpAddresses(final List<String> result, final List<String> cur,
                                         final StringBuilder sb, final String s, final int i) {
    if (cur.size() > 4) {
      return;
    }
    if (i == s.length()) {
      if (sb.length() != 0) {
        cur.add(sb.toString());
      }
      if (cur.size() == 4) {
        result.add(String.join(".", cur));
      }
      if (sb.length() != 0) {
        cur.remove(cur.size() - 1);
      }
      return;
    }
    final char chr = s.charAt(i);
    final int len = sb.length();
    if (len == 0 || sb.charAt(0) != '0') {
      sb.append(chr);
      if (Integer.parseInt(sb.toString()) < 256) {
        restoreIpAddresses(result, cur, sb, s, i + 1);
      }
      sb.setLength(len);
    }
    if (sb.length() != 0) {
      cur.add(sb.toString());
      final StringBuilder nextSb = new StringBuilder().append(chr);
      restoreIpAddresses(result, cur, nextSb, s, i + 1);
      cur.remove(cur.size() - 1);
    }
  }
}
