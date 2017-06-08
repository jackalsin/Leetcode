package _051_100._098_Validate_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/6/2017.
 */
public class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> parentNodes = new ArrayDeque<>();
    Integer prev = null;
    while (!parentNodes.isEmpty() || root != null) {
       if (root != null) {
         parentNodes.addLast(root);
         root = root.left;
       } else {
         // get node
         root = parentNodes.removeLast();
         // do mid
         if (prev == null) {
           prev = root.val;
         } else if (prev >= root.val) {
           return false;
         }
         System.out.println(root.val);
         // do right
         root = root.right;
       }
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

    System.out.println(new Solution().isValidBST(root));
  }
}
