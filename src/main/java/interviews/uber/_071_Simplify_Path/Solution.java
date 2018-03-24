package interviews.uber._071_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {
  public String simplifyPath(String path) {
    final Deque<String> stack = new ArrayDeque<>();
    final String[] paths = path.split("/");
    for (final String dir : paths) {
      switch (dir) {
        case ".":
        case "":
          continue;
        case "..":
          if (!stack.isEmpty()) {
            stack.removeLast();
          }
          break;
        default:
          stack.addLast(dir);
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (final String dir : stack) {
      sb.append("/").append(dir);
    }

    return sb.length() == 0 ? "/" : sb.toString();
  }
}
