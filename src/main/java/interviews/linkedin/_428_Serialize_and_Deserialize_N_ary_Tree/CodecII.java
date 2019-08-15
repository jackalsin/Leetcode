package interviews.linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.treeNode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class CodecII implements Codec {

  private static final String SEP = ",", END = ")", NULL = "#";

  public String serialize(Node root) {
    final StringBuilder sb = new StringBuilder();
    if (root == null) {
      return sb.toString();
    }
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, final Node root) {
    sb.append(SEP).append(root.val);
    for (Node child : root.children) {
      serialize(sb, child);
    }
    sb.append(SEP).append(END);
  }

  public Node deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
    return deserialize(q);
  }

  private Node deserialize(Queue<String> q) {
    final String toRemove = q.remove();
    final List<Node> children = new ArrayList<>();
    final Node root = new Node(Integer.parseInt(toRemove), children);
    while (!q.isEmpty() && !q.peek().equals(END)) {
      children.add(deserialize(q));
    }
    q.remove(); // remove end
    return root;
  }
}
