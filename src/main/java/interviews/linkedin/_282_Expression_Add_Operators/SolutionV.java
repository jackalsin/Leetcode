package interviews.linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

public final class SolutionV implements Solution {
  @Override
  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    if (num == null) {
      return result;
    }
    dfs(result, num.toCharArray(), target, 0, new StringBuilder(), 0, 1);
    return result;
  }

  private static void dfs(final List<String> result, final char[] str, final int target,
                          final int start, final StringBuilder curPath,
                          final long l1, final long l2) {
    if (start == str.length) {
      if (l1 + l2 == target) {
        result.add(curPath.toString());
      }
      return;
    }
    final int curLen = curPath.length();
    final StringBuilder curNumSb = new StringBuilder();
    long curNum = 0;
    for (int i = start; i < str.length; ++i) {
      if (i > start && str[start] == '0') break;
      final char chr = str[i];
      final int curDigit = chr - '0';
      curNumSb.append(chr);
      curNum = curNum * 10 + curDigit;
      // use plus
      if (curLen != 0) {
        curPath.append("+");
      }
      curPath.append(curNum);
      dfs(result, str, target, i + 1, curPath, l1 + (curLen == 0 ? 0 : l2), curNum);
      curPath.setLength(curLen);
      if (curLen != 0) {
        curPath.append("-").append(curNumSb);
        dfs(result, str, target, i + 1, curPath, l1 + l2, -curNum);
        curPath.setLength(curLen);
        curPath.append("*").append(curNumSb);
        dfs(result, str, target, i + 1, curPath, l1, l2 * curNum);
        curPath.setLength(curLen);
      }
    }
  }
}
