package linkedin._449_Serialize_and_Deserialize_BST;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class CodecI implements Codec {
  private static final String SEP = ",";

  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  public void serialize(final StringBuilder sb, final TreeNode root) {
    if (root == null) {
      return;
    }
    sb.append(SEP).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    final String[] valStrs = data.split(SEP);
    final Queue<Integer> q = new ArrayDeque<>();
    for (String v : valStrs) {
      q.add(Integer.parseInt(v));
    }
    return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public TreeNode deserialize(Queue<Integer> q, final long min, final int max) {
    while (!q.isEmpty() && min <= q.peek() && q.peek() <= max) {
      final TreeNode root = new TreeNode(q.remove());
      root.left = deserialize(q, min, root.val);
      root.right = deserialize(q, root.val, max);
      return root;
    }
    return null;
  }
}
