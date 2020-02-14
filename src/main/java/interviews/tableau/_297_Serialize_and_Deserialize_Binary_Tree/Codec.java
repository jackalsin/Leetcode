package interviews.tableau._297_Serialize_and_Deserialize_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/14/2020
 */
public interface Codec {
  // Encodes a tree to a single string.
  String serialize(TreeNode root);

  // Decodes your encoded data to tree.
  TreeNode deserialize(String data);
}
