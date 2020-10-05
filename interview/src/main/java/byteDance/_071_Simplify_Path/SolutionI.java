package byteDance._071_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhixi
 * @version 1.0 on 5/6/2020
 */
public final class SolutionI implements Solution {
  private static final String UP = "..", CUR = ".";

  public String simplifyPath(String path) {
    if (path == null || path.isEmpty()) {
      return path;
    }
    final String[] items = path.split("/");
    final Deque<String> stack = new ArrayDeque<>();
    for (String item : items) {
      if (item.isEmpty() || CUR.equals(item)) continue;
      if (UP.endsWith(item)) {
        if (!stack.isEmpty()) {
          stack.removeLast();
        }
      } else {
        stack.addLast(item);
      }
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.removeFirst());
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }
}
