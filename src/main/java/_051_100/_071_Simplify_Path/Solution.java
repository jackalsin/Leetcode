package _051_100._071_Simplify_Path;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/28/2017.
 */
public class Solution {
  public String simplifyPath(String path) {
    Deque<String> pathStack = new ArrayDeque<>();
    String[] dirs = path.split("/");
    Set<String> set = new HashSet<>(Arrays.asList("..", ".",""));
    for (String child: dirs) {
      if (child.equals("..") && !pathStack.isEmpty()) {
        pathStack.removeLast();
      } else if (!set.contains(child)) {
        pathStack.addLast(child);
      }
    }
    StringBuilder result = new StringBuilder();
    while (!pathStack.isEmpty()) {
      result.append('/').append(pathStack.removeFirst());
    }
    return result.length() == 0 ? "/": result.toString();
  }

  public static void main(String[] args) {
    String tab = "/a/./b/../../c/";
    System.out.println(Arrays.toString(tab.split("/")));
  }
}
