package linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionIV implements Solution {

  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    dfs(result, num, target, "", 0, 0, 1);
    return result;
  }

  private static void dfs(final List<String> result, final String num, final int target, final String curPath,
                          int start, final long l1, long l2) {
    if (start == num.length()) {
      if (l1 + l2 == target) {
        result.add(curPath);
      }
      return;
    }

    for (int i = start; i < num.length(); ++i) {
      // skip 05, 005
      if (i > start && num.charAt(start) == '0') continue;
      final String curNumStr = num.substring(start, i + 1);
      final long curNum = Long.parseLong(curNumStr);

      // TODO: check len == 0
      dfs(result, num, target, curPath.length() == 0 ? curNumStr : curPath + "+" + curNumStr, i + 1,
          curPath.length() == 0 ? 0 : l1 + l2, curNum);

      if (start != 0) {
        dfs(result, num, target, curPath + "-" + curNumStr, i + 1, l1 + l2, -curNum);
        dfs(result, num, target, curPath + "*" + curNumStr, i + 1, l1, l2 * curNum);
      }

    }
  }
}
