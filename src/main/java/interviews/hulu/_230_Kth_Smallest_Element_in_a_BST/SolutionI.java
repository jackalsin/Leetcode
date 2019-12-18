package interviews.hulu._230_Kth_Smallest_Element_in_a_BST;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class SolutionI implements Solution {
  private final Map<TreeNode, Integer> childCount = new HashMap<>();

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return 0;
    }
    final int left = getDepth(root.left);
    if (left + 1 == k) {
      return root.val;
    } else if (left + 1 < k) {
      return kthSmallest(root.right, k - (left + 1));
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (childCount.containsKey(root)) {
      return childCount.get(root);
    }
    final int left = getDepth(root.left),
        right = getDepth(root.right);
    final int res = left + right + 1;
    childCount.put(root, res);
    return res;
  }
}
