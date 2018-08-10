package interviews.microsoft.noodleEssence._297_Serialize_and_Deserialize_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Codec {
  private static final String SEP = ",", NULL = "#";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.toString();
  }

  private void serialize(final StringBuilder sb, final TreeNode root) {
    if (root == null) {
      sb.append(NULL).append(SEP);
      return;
    }
    sb.append(root.val).append(SEP);
    serialize(sb, root.left);
    serialize(sb, root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final String[] dataArray = data.split(SEP);
    final Queue<String> queue = new ArrayDeque<>(Arrays.asList(dataArray));
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    final String strVal = queue.remove();
    if (NULL.equals(strVal)) {
      return null;
    }
    final int val = Integer.parseInt(strVal);
    final TreeNode root = new TreeNode(val);
    root.left = deserialize(queue);
    root.right = deserialize(queue);
    return root;
  }
}
