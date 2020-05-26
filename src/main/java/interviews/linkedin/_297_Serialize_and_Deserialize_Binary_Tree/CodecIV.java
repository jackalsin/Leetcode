package interviews.linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 7/20/2019
 */
public final class CodecIV implements Codec {
  private static final String SEP = ",", NULL = "#";

  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, TreeNode root) {
    if (root == null) {
      sb.append(SEP).append(NULL);
      return;
    }
    sb.append(SEP).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }


  public TreeNode deserialize(String data) {
    if (data == null) {
      throw new NullPointerException();
    }
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private static TreeNode deserialize(final Queue<String> q) {
    final String toRemove = q.remove();
    if (toRemove.equals(NULL)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.parseInt(toRemove));
    root.left = deserialize(q);
    root.right = deserialize(q);
    return root;
  }
}
