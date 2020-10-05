package _0551_0600._559_Maximum_Depth_of_N_ary_Tree;

import definition._559_Maximum_Depth_of_N_ary_Tree.Node;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int depth = 1;
    if (root.children == null || root.children.isEmpty()) {
      return depth;
    }
    for (final Node child : root.children) {
      depth = Math.max(depth, maxDepth(child) + 1);
    }
    return depth;
  }
}
