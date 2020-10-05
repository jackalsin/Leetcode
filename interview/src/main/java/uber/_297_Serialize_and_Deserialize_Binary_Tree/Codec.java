package uber._297_Serialize_and_Deserialize_Binary_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public final class Codec {
  private static final String SPLIT = ",", NULL = "#";


  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private void serialize(StringBuilder sb, TreeNode root) {
    if (root == null) {
      sb.append(SPLIT).append(NULL);
      return;
    }

    sb.append(SPLIT).append(root.val);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }


  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final String[] arr = data.split(SPLIT);
    final Queue<String> queue = new ArrayDeque<>(Arrays.asList(arr));
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    final String cur = queue.remove();
    if (cur.equals(NULL)) {
      return null;
    }
    final TreeNode root = new TreeNode(Integer.parseInt(cur));
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
  }
}
