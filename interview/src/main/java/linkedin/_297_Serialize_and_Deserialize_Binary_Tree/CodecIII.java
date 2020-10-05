package linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class CodecIII implements Codec {
  private static final String SEP = ",", NULL = "#";

  @Override
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(StringBuilder sb, TreeNode root) {
    if (root == null) {
      sb.append(SEP).append(NULL);
      return;
    }
    sb.append(SEP).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  @Override
  public TreeNode deserialize(String data) {
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private static TreeNode deserialize(final Queue<String> q) {

    final String str = q.remove();
    if (NULL.equals(str)) {
      return null;
    }

    final TreeNode root = new TreeNode(Integer.parseInt(str));
    root.left = deserialize(q);
    root.right = deserialize(q);
    return root;
  }
}
