package _1101_1150._1110_Delete_Nodes_And_Return_Forest;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    final Set<Integer> toDelete = new HashSet<>();
    for (final int d : to_delete) {
      toDelete.add(d);
    }
    final List<TreeNode> result = new ArrayList<>();
    if (root == null) {
      return null;
    }
    delNodes(result, root, null, toDelete);

    return result;
  }

  private void delNodes(final List<TreeNode> result, final TreeNode root, final TreeNode parent,
                        final Set<Integer> toDelete) {
    if (root == null) {
      return;
    }
    if (toDelete.contains(root.val)) {
      if (parent != null) {
        if (parent.left == root) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      }
      delNodes(result, root.left, null, toDelete);
      delNodes(result, root.right, null, toDelete);
    } else {
      if (parent == null) {
        result.add(root);
      }
      delNodes(result, root.left, root, toDelete);
      delNodes(result, root.right, root, toDelete);
    }
  }
}
