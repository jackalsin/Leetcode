package _0401_0450._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.nAryTree.Node;

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
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, final Node root) {
    sb.append(SEP).append(root.val);
    for (Node c : root.children) {
      serialize(sb, c);
    }
    sb.append(SEP).append(END);
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.length() == 0) {
      return null;
    }

    Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private static Node deserialize(final Queue<String> q) {
    final String valStr = q.remove();
    final Node root = new Node(Integer.parseInt(valStr), new ArrayList<>());
    assert !q.isEmpty();
    while (!q.peek().equals(END)) {
      root.children.add(deserialize(q));
    }
    q.remove();
    return root;
  }
}
