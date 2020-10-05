package _0151_0200._156_Binary_Tree_Upside_Down;

import definition.binaryTree.TreeNode;

public class Solution {
    /**
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
     * Well explanation: https://discuss.leetcode.com/topic/40924/java-recursive-o-logn-space-and-iterative-solutions-o-1-space-with-explanation-and-figure
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return iterative(root);
    }

    private TreeNode iterative(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode temp = null;
        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    private TreeNode recursion(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
