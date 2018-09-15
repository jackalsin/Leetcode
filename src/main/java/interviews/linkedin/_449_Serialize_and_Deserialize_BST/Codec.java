package interviews.linkedin._449_Serialize_and_Deserialize_BST;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public final class Codec {

  // todo: 重新搞过，貌似有save space 的方法
  private static final String SEP = ",", NULL = "#";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, final TreeNode root) {
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
