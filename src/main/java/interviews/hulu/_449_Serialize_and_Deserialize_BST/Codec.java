package interviews.hulu._449_Serialize_and_Deserialize_BST;

import utils.binaryTree.TreeNode;

/**
 * TODO:
 *
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public interface Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root);

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data);
}
