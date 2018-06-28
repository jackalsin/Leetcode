package interviews.linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class CodecII implements Codec {
  private static final String SEP = ",", NULL = "#";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    buildString(sb, root);
    return sb.toString();
  }

  private void buildString(StringBuilder sb, TreeNode root) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return;
    }
    sb.append(root.val).append(SEP);
    buildString(sb, root.left);
    buildString(sb, root.right);
  }

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
