package uber._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public final class Codec {
  private static final String NULL = "#", SEP = ",", END = ")";

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.toString();
  }

  private void serialize(final StringBuilder sb, final Node root) {
    if (root == null) {
      sb.append(NULL);
      return;
    }

    sb.append(root.val).append(SEP);
    for (Node child : root.children) {
      serialize(sb, child);
    }
    sb.append(END).append(SEP);
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.equals(NULL)) {
      return null;
    }

    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private static Node deserialize(final Queue<String> q) {
    final String rootStr = q.remove();
    final List<Node> children = new ArrayList<>();
    final Node root = new Node(Integer.parseInt(rootStr), children);
    while (true) {
      if (END.equals(q.peek())) {
        q.remove();
        break;
      }
      children.add(deserialize(q));
    }
    return root;
  }
}
