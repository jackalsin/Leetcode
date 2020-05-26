package interviews.linkedin._449_Serialize_and_Deserialize_BST;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class CodecII implements Codec {
  private static final String SEP = ",";

  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, final TreeNode root) {
    if (root == null) {
      return;
    }
    sb.append(SEP).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  public TreeNode deserialize(String data) {
    if (data == null) {
      return null;
    }
    final Queue<Integer> q = new ArrayDeque<>();
    final String[] items = data.split(SEP);
    for (String str : items) {
      q.add(Integer.parseInt(str));
    }
    return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static TreeNode deserialize(final Queue<Integer> q, final int min, final int max) {
    while (!q.isEmpty() && min < q.peek() && q.peek() < max) {
      final int val = q.remove();
      final TreeNode cur = new TreeNode(val);
      cur.left = deserialize(q, min, val);
      cur.right = deserialize(q, val, max);
      return cur;
    }
    return null;
  }
}
