package _1001_1050._1145_Binary_Tree_Coloring_Game;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, TreeNode> childToParents = new HashMap<>();
  private final Map<Integer, List<TreeNode>> parentToChildren = new HashMap<>();
  private final Map<Integer, Integer> childrenCount = new HashMap<>();

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    countChildren(root);
    if (root == null) {
      return false;
    }
    if (x == root.val) {
      final List<TreeNode> children = parentToChildren.get(root.val);
      if (children.isEmpty()) {
        return false;
      }
      if (children.size() == 1) {
        return true;
      }
      final int leftCount = childrenCount.get(children.get(0).val),
          rightCount = childrenCount.get(children.get(1).val),
          min = Math.min(leftCount, rightCount),
          max = Math.max(leftCount, rightCount);
      return max > min + 1;
    }
    final List<TreeNode> children = parentToChildren.get(x);
    if (children.isEmpty()) {
      return true; // we pick the parent
    }
    if (children.size() == 1) {
      final int childChildrenCount = childrenCount.get(children.get(0).val),
          countIfColorParent = childrenCount.get(root.val) - childrenCount.get(x);
      return childChildrenCount > n - childChildrenCount || countIfColorParent > n - countIfColorParent;
    }
    final int leftCount = childrenCount.get(children.get(0).val),
        rightCount = childrenCount.get(children.get(1).val),
        countIfColorParent = childrenCount.get(root.val) - childrenCount.get(x);
    final int max = Math.max(Math.max(countIfColorParent, rightCount), leftCount),
        other = n - max;
    return max > other;
  }

  private int countChildren(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final List<TreeNode> children = new ArrayList<>();
    if (root.left != null) {
      children.add(root.left);
      childToParents.put(root.left.val, root);
    }
    if (root.right != null) {
      children.add(root.right);
      childToParents.put(root.right.val, root);
    }
    parentToChildren.put(root.val, children);
    final int left = countChildren(root.left),
        right = countChildren(root.right),
        res = left + right + 1;
    childrenCount.put(root.val, res);
    return res;
  }

}
