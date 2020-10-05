package tableau._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/14/2020
 */
public final class CodecI implements Codec {
  private static final String SEP = ",", NULL = "#";

  public String serialize(TreeNode root) {
    if (root == null) {
      return NULL;
    }
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.toString();
  }

  private static void serialize(final StringBuilder sb, final TreeNode root) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return;
    }
    sb.append(root.val).append(SEP);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  public TreeNode deserialize(String data) {
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
