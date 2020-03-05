package _0601_0650._606_Construct_String_from_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }
    final StringBuilder sb = new StringBuilder().append(t.val);

    if (t.left != null) {
      sb.append("(");
      sb.append(tree2str(t.left));
      sb.append(")");
    }
    if (t.right != null) {
      if (t.left == null) {
        sb.append("()");
      }
      sb.append("(");
      sb.append(tree2str(t.right));
      sb.append(")");
    }
    return sb.toString();
  }
}
