package _1101_1150._1145_Binary_Tree_Coloring_Game;

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
  private final Map<Integer, List<TreeNode>> parentToChildren = new HashMap<>();
  private final Map<Integer, Integer> childrenCount = new HashMap<>();

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    countChildren(root);
    if (root == null) {
      return false;
    }
    final int pickParent = childrenCount.get(root.val) - childrenCount.get(x);
    final List<TreeNode> children = parentToChildren.get(x);
//    System.out.println(parentToChildren);
//    System.out.println(children);
    final int pickChild = getPickChild(children);
//    System.out.println(childrenCount);
//    System.out.printf("Pick Child = %d, pick parent = %d\n", pickChild, pickParent);
    final int myMaxCount = Math.max(pickParent, pickChild);
    return n - myMaxCount < myMaxCount;
  }

  private int getPickChild(final List<TreeNode> children) {
    if (children.isEmpty()) {
      return 0;
    }
    int res = 0;
    for (final TreeNode c : children) {
      res = Math.max(childrenCount.get(c.val), res);
    }
    return res;
  }

  private int countChildren(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (childrenCount.containsKey(root.val)) {
      return childrenCount.get(root.val);
    }
    final List<TreeNode> children = new ArrayList<>();
    if (root.left != null) {
      children.add(root.left);
    }
    if (root.right != null) {
      children.add(root.right);
    }
    parentToChildren.put(root.val, children);
    final int left = countChildren(root.left),
        right = countChildren(root.right),
        res = left + right + 1;
    childrenCount.put(root.val, res);
    return res;
  }

}
