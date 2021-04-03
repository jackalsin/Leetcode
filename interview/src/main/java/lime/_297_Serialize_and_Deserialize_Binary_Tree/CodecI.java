package lime._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/2/2021
 */
public final class CodecI implements Codec {
  private static final String NULL = "#",
      SEP = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private static void serialize(final TreeNode root, final StringBuilder sb) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return;
    }
    sb.append(root.val).append(SEP);
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null) return null;
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private static TreeNode deserialize(final Queue<String> q) {
    final String toRemove = q.remove();
    if (NULL.equals(toRemove)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.parseInt(toRemove));
    root.left = deserialize(q);
    root.right = deserialize(q);
    return root;
  }

}
