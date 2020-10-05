package _0401_0450._449_Serialize_and_Deserialize_BST;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 62 / 62 test cases passed.
 * Status: Accepted
 * Runtime: 20 ms
 */
public final class Codec {
  private static final String SPLIT = "#";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static void serialize(TreeNode root, final StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(SPLIT).append(root.val);
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final String[] dataArray = data.split(SPLIT);
    final Queue<Integer> queue = new ArrayDeque<>();
    for (String child : dataArray) {
      if (!child.isEmpty()) {
        queue.add(Integer.parseInt(child));
      }
    }
    return deserialize(queue);
  }

  private static TreeNode deserialize(final Queue<Integer> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    final TreeNode root = new TreeNode(queue.remove());
    final Queue<Integer> smallerQueue = new ArrayDeque<>();
    while (!queue.isEmpty() && queue.peek() < root.val) {
      smallerQueue.add(queue.remove());
    }
    root.left = deserialize(smallerQueue);
    root.right = deserialize(queue);
    return root;
  }
}
