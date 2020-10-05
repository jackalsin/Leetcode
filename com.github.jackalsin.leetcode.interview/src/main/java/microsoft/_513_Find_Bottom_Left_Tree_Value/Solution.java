package microsoft._513_Find_Bottom_Left_Tree_Value;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  public int findBottomLeftValue(TreeNode root) {
    final Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int res = root.val;
    while (!queue.isEmpty()) {
      final int size = queue.size();
      res = queue.peek().val;
      for (int i = 0; i < size; i++) {
        final TreeNode toRemove = queue.remove();
        if (toRemove.left != null) {
          queue.add(toRemove.left);
        }
        if (toRemove.right != null) {
          queue.add(toRemove.right);
        }
      }
    }
    return res;
  }
}
