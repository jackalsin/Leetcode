package _0401_0450._431_Encode_N_ary_Tree_to_Binary_Tree;


import utils.binaryTree.TreeNode;
import utils.nAryTree.Node;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public interface Solution {

  // Encodes an n-ary tree to a binary tree.
  TreeNode encode(Node root);

  // Decodes your binary tree to an n-ary tree.
  Node decode(TreeNode root);
}
