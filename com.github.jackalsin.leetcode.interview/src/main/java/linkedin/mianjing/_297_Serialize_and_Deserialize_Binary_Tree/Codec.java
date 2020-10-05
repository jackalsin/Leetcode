package linkedin.mianjing._297_Serialize_and_Deserialize_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public final class Codec {
  private static final String NULL = "#", SEP = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    // inorder
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private void serialize(final StringBuilder sb, final TreeNode root) {
    if (root == null) {
      sb.append(SEP).append(NULL);
      return;
    }
    sb.append(SEP).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    final String rootStr = queue.remove();
    if (rootStr.equals(NULL)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.valueOf(rootStr));
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
  }

}
