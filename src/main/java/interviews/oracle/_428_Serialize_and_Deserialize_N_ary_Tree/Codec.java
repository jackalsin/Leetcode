package interviews.oracle._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.treeNode.Node;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public interface Codec {
  // Encodes a tree to a single string.
  String serialize(Node root);

  // Decodes your encoded data to tree.
  Node deserialize(String data);
}
