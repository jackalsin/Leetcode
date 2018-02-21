package interviews.uber._230_Kth_Smallest_Element_in_a_BST;

import utils.TreeNode;

public class Solution {
//  private final Map<TreeNode, Integer> nodeCounts = new HashMap<>();

  public int kthSmallest(TreeNode root, int k) {
    int leftCounts = countNodes(root.left);
    if (leftCounts == k - 1) {
      return root.val;
    } else if (leftCounts < k - 1) {
      return kthSmallest(root.right, k - leftCounts - 1);
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
//    if (nodeCounts.containsKey(root)) {
//      return nodeCounts.get(root);
//    }

    int res = 1 + countNodes(root.left) + countNodes(root.right);
//    nodeCounts.put(root, res);

    return res;
  }
}
