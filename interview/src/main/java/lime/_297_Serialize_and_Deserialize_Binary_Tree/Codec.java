package lime._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/2/2021
 */
public interface Codec {
  // Encodes a tree to a single string.
  String serialize(TreeNode root);

  // Decodes your encoded data to tree.
  TreeNode deserialize(String data);
}
