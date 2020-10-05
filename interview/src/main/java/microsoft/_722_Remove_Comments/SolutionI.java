package microsoft._722_Remove_Comments;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {

  /**
   * 53 / 53 test cases passed.
   * Status: Accepted
   * Runtime: 5 ms
   *
   * @param source
   * @return
   */
  public List<String> removeComments(String[] source) {
    final List<String> result = new ArrayList<>();
    boolean inBlock = false;
    final StringBuilder sb = new StringBuilder();
    for (final String line : source) {
      if (!inBlock) sb.setLength(0);
      final char[] chars = line.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        if (!inBlock && chars[i] == '/' && i + 1 < chars.length && chars[i + 1] == '*') {
          inBlock = true;
          i++;
        } else if (!inBlock && chars[i] == '/' && i + 1 < chars.length && chars[i + 1] == '/') {
          break;
        } else if (inBlock && chars[i] == '*' && i + 1 < chars.length && chars[i + 1] == '/') {
          inBlock = false;
          i++;
        } else if (!inBlock) {
          sb.append(chars[i]);
        }
      }
      if (!inBlock && sb.length() != 0) {
        result.add(sb.toString());
      }
    }
    return result;
  }

}
