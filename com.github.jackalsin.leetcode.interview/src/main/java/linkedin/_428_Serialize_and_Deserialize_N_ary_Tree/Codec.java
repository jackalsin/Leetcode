package linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.nAryTree.Node;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public interface Codec {

  // Encodes a tree to a single string.
  String serialize(Node root);

  // Decodes your encoded data to tree.
  Node deserialize(String data);
}
