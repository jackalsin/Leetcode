package interviews.microsoft._297_Serialize_and_Deserialize_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Codec {
  private static final String NULL = "#", SEP = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private void serialize(StringBuilder sb, TreeNode root) {
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
    return buildTree(queue);
  }

  private TreeNode buildTree(Queue<String> queue) {
    final String toRemove = queue.remove();
    if (toRemove.equals(NULL)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.parseInt(toRemove));
    root.left = buildTree(queue);
    root.right = buildTree(queue);
    return root;
  }
}
