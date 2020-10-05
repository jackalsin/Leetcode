package linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public final class SolutionI implements Solution {

  /**
   * Time Complexity: O(4^(N - 1))
   * Space Complexity: O(3^N)
   *
   * @param num
   * @param target
   * @return
   */
  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    dfs(result, num, target, "", 0, 0, 1);
    return result;
  }

  private static void dfs(final List<String> result, final String num, final int target,
                          final String curPath, final int start, final long l1, final long l2) {
    if (start == num.length()) {
      if (l1 + l2 == target) {
        result.add(curPath);
      }
      return;
    }

    for (int i = start; i < num.length(); ++i) {
      if (num.charAt(start) == '0' && i > start) { // leading 0
        break;
      }

      final long curNum = Long.parseLong(num.substring(start, i + 1));
      dfs(result, num, target, curPath.length() == 0 ? "" + curNum : curPath + "+" + curNum, i + 1,
          l1 + (curPath.length() == 0 ? 0 : l2), curNum);

      if (curPath.length() != 0) {
        dfs(result, num, target, curPath + "-" + curNum, i + 1, l1 + l2, -1 * curNum);
        dfs(result, num, target, curPath + "*" + curNum, i + 1, l1, l2 * curNum);
      }
    }
  }

}
