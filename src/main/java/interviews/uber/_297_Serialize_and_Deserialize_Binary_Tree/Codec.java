package interviews.uber._297_Serialize_and_Deserialize_Binary_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
    } else {
      sb.append(SPLIT).append(root.val);
      serialize(sb, root.left);
      serialize(sb, root.right);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    final String[] strs = data.split(SPLIT);
    final Deque<String> deque = new ArrayDeque<>(Arrays.asList(strs));
    return deserialize(deque);
  }

  private TreeNode deserialize(final Deque<String> deque) {
    final String val = deque.remove();
    if (val.equals(NULL)) {
      return null;
    } else {
      final TreeNode root = new TreeNode(Integer.valueOf(val));
      root.left = deserialize(deque);
      root.right = deserialize(deque);
      return root;
    }
  }
}
