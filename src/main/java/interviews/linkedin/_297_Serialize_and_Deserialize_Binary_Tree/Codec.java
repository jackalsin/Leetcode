package interviews.linkedin._297_Serialize_and_Deserialize_Binary_Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class Codec {
  private static final String INVALID = "#";
  private static final String SEP = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  private void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append(INVALID).append(SEP);
    } else {
      sb.append(root.val).append(SEP);
      buildString(root.left, sb);
      buildString(root.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Deque<String> deque = new ArrayDeque<>();
    deque.addAll(Arrays.asList(data.split(SEP)));

    return buildTree(deque);
  }

  private TreeNode buildTree(Deque<String> deque) {
    String val = deque.remove();
    if (val.equals(INVALID)) {
      return null;
    } else {
      TreeNode root = new TreeNode(Integer.valueOf(val));
      root.left = buildTree(deque);
      root.right = buildTree(deque);
      return root;
    }
  }

}
