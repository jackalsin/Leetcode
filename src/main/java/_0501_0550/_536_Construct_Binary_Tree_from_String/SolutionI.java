package _0501_0550._536_Construct_Binary_Tree_from_String;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode str2tree(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }
    final Deque<TreeNode> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == ')') {
        stack.pop();
      } else if (chr == '-' || Character.isDigit(chr)) {
        int start = i;
        while (i + 1 < s.length() && (Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == '-')) {
          i++;
        }
        final TreeNode cur = new TreeNode(Integer.parseInt(s.substring(start, i + 1)));
        if (!stack.isEmpty()) {
          if (stack.peek().left == null) {
            stack.peek().left = cur;
          } else {
            stack.peek().right = cur;
          }
        }
        stack.push(cur);
      }
    }
    assert !stack.isEmpty();
    return stack.peek();
  }
}
