package microsoft._071_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public String simplifyPath(String path) {
    final Deque<String> stack = new ArrayDeque<>();
    final String[] pathArray = path.split("/");
    for (String dir : pathArray) {
      switch (dir) {
        case "..":
          if (!stack.isEmpty()) {
            stack.pop();
          }
          break;
        case ".":
        case "":
          break;
        default:
          stack.push(dir);
      }
    }
    final StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.append('/').append(stack.removeLast());
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }
}
