package interviews.linkedin._449_Serialize_and_Deserialize_BST;

import utils.TreeNode;

/**
 * todo: 重新搞过，貌似有save space 的方法
 *
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public interface Codec {

  // Encodes a tree to a single string.
  String serialize(TreeNode root);

  // Decodes your encoded data to tree.
  TreeNode deserialize(String data);
}
