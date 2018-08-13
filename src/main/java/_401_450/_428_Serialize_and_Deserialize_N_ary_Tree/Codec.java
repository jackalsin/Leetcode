package _401_450._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.treeNode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Codec {
  private static final String SEP = ",", END = ")";

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    if (root == null) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.toString();
  }

  private static void serialize(final StringBuilder sb, final Node root) {
    assert (root != null);
    sb.append(root.val).append(SEP);
    for (final Node child : root.children) {
      serialize(sb, child);
    }
    sb.append(END).append(SEP);
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.length() == 0) {
      return null;
    }
    final String[] dataArray = data.split(SEP);
    final Queue<String> queue = new ArrayDeque<>(Arrays.asList(dataArray));
    return deserialize(queue);
  }

  private static Node deserialize(final Queue<String> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    final String toRemove = queue.remove();
    if (END.equals(toRemove)) {
      return null;
    }
    final Node root = new Node();
    root.val = Integer.parseInt(toRemove);
    root.children = new ArrayList<>();
    Node next;
    while ((next = deserialize(queue)) != null) {
      root.children.add(next);
    }
    return root;
  }
}
