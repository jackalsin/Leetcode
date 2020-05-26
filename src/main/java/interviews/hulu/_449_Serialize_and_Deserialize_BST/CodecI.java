package interviews.hulu._449_Serialize_and_Deserialize_BST;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class CodecI implements Codec {
  private static final String SEP = ",";

  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    if (root == null) return sb.toString();
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
    if (data == null || "".equals(data)) return null;
    final String[] input = data.split(SEP);
    final int n = input.length;
    final Queue<Integer> q = new ArrayDeque<>();
    for (final String d : input) {
      q.add(Integer.parseInt(d));
    }
    return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static TreeNode deserialize(final Queue<Integer> q, int min, final int max) {
    if (q.isEmpty()) {
      return null; // TODO: will ?
    }
//    if (min > max) {
//      return null;
//    }
    if (min < q.peek() && q.peek() < max) {
      final TreeNode root = new TreeNode(q.remove());
      root.left = deserialize(q, min, root.val);
      root.right = deserialize(q, root.val, max);
      return root;
    }
    return null;
  }
}
