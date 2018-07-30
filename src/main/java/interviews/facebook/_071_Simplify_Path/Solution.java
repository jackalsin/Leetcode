package interviews.facebook._071_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public String simplifyPath(String path) {
    final String[] pathArray = path.split("/");
    final Deque<String> stack = new ArrayDeque<>();
    for (String p : pathArray) {
      switch (p) {
        case ".":
        case "":
          break;
        case "..":
          if (!stack.isEmpty()) {
            stack.pop();
          }
          break;
        default:
          stack.push(p);
      }
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append("/").append(stack.removeLast());
    }
    return sb.length() == 0 ? "/" : sb.toString();
  }
}
