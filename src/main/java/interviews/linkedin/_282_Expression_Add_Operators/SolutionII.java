package interviews.linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionII implements Solution {

  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    dfs(result, num, target, "", 0, 0, 1);
    return result;
  }

  private static void dfs(final List<String> result, final String num, final int target, String s, int start, long l1, long l2) {
    if (num.length() == start) {
      if (target == l1 + l2) {
        result.add(s);
      }
      return;
    }

    for (int i = start; i < num.length(); ++i) {
      if (i > start && num.charAt(start) == '0') {
        break;
      }
      final String numString = num.substring(start, i + 1);
      final long n = Long.parseLong(numString);

      dfs(result, num, target, s.length() == 0 ? String.valueOf(n) : (s + "+" + n), start + numString.length(),
          l1 + (s.length() == 0 ? 0 : l2), n);
      if (start != 0) {
        dfs(result, num, target, s + "-" + n, start + numString.length(), l1 + l2, -n);
        dfs(result, num, target, s + "*" + n, start + numString.length(), l1, l2 * n);
      }
    }

  }

}
