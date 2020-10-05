package _0401_0450._431_Encode_N_ary_Tree_to_Binary_Tree;


import utils.binaryTree.TreeNode;
import utils.nAryTree.Node;

import java.util.ArrayList;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class SolutionI implements Solution {
  /**
   * left -> next Level, right -> same level
   *
   * @param root
   * @return
   */
  public TreeNode encode(Node root) {
    if (root == null) {
      return null;
    }
    final TreeNode result = new TreeNode(root.val);
    if (root.children == null) return result;
    if (!root.children.isEmpty()) {
      result.left = encode(root.children.get(0));
    }
    TreeNode cur = result.left;
    for (int i = 1; i < root.children.size(); ++i) {
      cur.right = encode(root.children.get(i));
      cur = cur.right;
    }
    return result;
  }

  public Node decode(TreeNode root) {
    if (root == null) {
      return null;
    }
    final Node result = new Node(root.val, new ArrayList<>());
    TreeNode cur = root.left;
    while (cur != null) {
      result.children.add(decode(cur));
      cur = cur.right;
    }
    return result;
  }
}
