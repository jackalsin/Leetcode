package linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import definition.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/5/2019
 */
public final class CodecIII implements Codec {
  private static final String END = ")", SEP = ",";

  public String serialize(Node root) {
    if (root == null) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(StringBuilder sb, Node root) {
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

  private static Node deserialize(final Queue<String> q) {
    final String rootStr = q.remove();
    final List<Node> children = new ArrayList<>();
    final Node root = new Node(Integer.parseInt(rootStr), children);
    while (!END.equals(q.peek())) {
      children.add(deserialize(q));
    }
    q.remove();
    return root;
  }
}
