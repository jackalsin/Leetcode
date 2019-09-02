package interviews.linkedin._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/2/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    addOperators(result, num, target, new StringBuilder(), 0, 0, 1);
    return result;
  }

  private static void addOperators(final List<String> result, final String num, final int target,
                                   final StringBuilder curPath, final int start, final long l1, final long l2) {
    if (start == num.length()) {
      if (l1 + l2 == target) result.add(curPath.toString());
      return;
    }
    long cur = 0;
    final int curLen = curPath.length();
    for (int end = start; end < num.length(); ++end) {
      final char chr = num.charAt(end);
      if (end > start && num.charAt(start) == '0') return;
      cur = cur * 10 + chr - '0';
      // plus
      if (curLen != 0) {
        curPath.append("+");
      }
      curPath.append(cur);
      addOperators(result, num, target, curPath, end + 1, l1 + (curLen == 0 ? 0 : l2), cur);
      curPath.setLength(curLen);
      if (curLen != 0) {
        curPath.append("-").append(cur);
        addOperators(result, num, target, curPath, end + 1, l1 + l2, -cur);
        curPath.setLength(curLen);
        curPath.append("*").append(cur);
        addOperators(result, num, target, curPath, end + 1, l1, l2 * cur);
        curPath.setLength(curLen);
      }
    }
  }
}
