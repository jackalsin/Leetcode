package _0401_0450._449_Serialize_and_Deserialize_BST;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public final class CodecON {
  private static final String SEP = ",";

  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    preOrder(root, sb);
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private void preOrder(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(SEP).append(root.val);
    preOrder(root.left, sb);
    preOrder(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() == 0) {
      return null;
    }
    final Queue<Integer> queue = Arrays.stream(data.split(SEP)).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    return deserialize(queue, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private static TreeNode deserialize(final Queue<Integer> queue, final long min, final long max) {
    if (!queue.isEmpty() && min < queue.peek() && queue.peek() < max) {
      final TreeNode root = new TreeNode(queue.remove());
      root.left = deserialize(queue, min, root.val);
      root.right = deserialize(queue, root.val, max);
      return root;
    }
    return null;
  }
}
