package interviews.linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionIII implements Solution {

  @Override
  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    if (num == null || num.length() == 0) {
      return result;
    }

    dfs(result, num, target, "", 0, 1, 0);
    return result;
  }

  private static void dfs(final List<String> result, final String num, final int target,
                          final String curPath, long l1, long l2, int start) {
    if (start == num.length()) {
      if (l1 + l2 == target) {
        result.add(curPath);
      }
      return;
    }
    for (int end = start; end < num.length(); end++) {
      if (end > start && num.charAt(start) == '0') {
        break;
      }
      final String curNumStr = num.substring(start, end + 1);
      long curNum = Long.parseLong(curNumStr);
      dfs(result, num, target, curPath.length() == 0 ? curNumStr : curPath + "+" + curNumStr,
          curPath.length() == 0 ? l1 : l1 + l2, curNum, end + 1);
      if (start > 0) {
        dfs(result, num, target, curPath.length() == 0 ? curNumStr : curPath + "-" + curNumStr, l1 + l2, -curNum, end + 1);
        dfs(result, num, target, curPath.length() == 0 ? curNumStr : curPath + "*" + curNumStr, l1, l2 * curNum, end + 1);
      }
    }
  }
}
