package uber.addChar;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 4/16/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String addChar(String a, String b) {
    final LinkedList<Integer> result = new LinkedList<>();
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; --i, --j) {
      final int left = i >= 0 ? a.charAt(i) - '0' : 0, right = j >= 0 ? b.charAt(j) - '0' : 0,
          sum = left + right;
      result.addFirst(sum);
    }
    final StringBuilder sb = new StringBuilder();
    for (int r : result) {
      sb.append(r);
    }
    return sb.toString();
  }
}
