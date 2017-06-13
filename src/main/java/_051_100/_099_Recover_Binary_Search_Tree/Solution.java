package _051_100._099_Recover_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/7/2017.
 */
public class Solution {
  /**
   * Two elements of a binary search tree (BST) are swapped by mistake.
   * Recover the tree without changing its structure.
   * Note:
   * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
   *
   * @param root
   */
  public void recoverTree(TreeNode root) {
    inorderTraversal(root);
//    morrisTraversal(root);
  }

  private void inorderTraversal(TreeNode root) {
    Deque<TreeNode> parentNodes = new ArrayDeque<>();
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    while (root != null || !parentNodes.isEmpty()) {
      if (root != null) {
        parentNodes.addLast(root);
        root = root.left;
      } else {
        TreeNode cur = parentNodes.removeLast();
        if (firstNode == null && prevNode.val > cur.val){
          firstNode = prevNode;
        }
        if (firstNode != null && prevNode.val > cur.val) {
          secondNode = cur;
          int tmp = firstNode.val;
          firstNode.val = secondNode.val;
          secondNode.val = tmp;
        }
        prevNode = cur;
        root = cur.right;
      }
    }
  }
}
