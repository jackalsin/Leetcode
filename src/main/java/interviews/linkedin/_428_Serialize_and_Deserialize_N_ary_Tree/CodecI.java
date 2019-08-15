package interviews.linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.treeNode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public final class CodecI implements Codec {

  private static final String SEP = ",", END = ")", NULL = "#";

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    if (root == null) {
      return NULL;
    }
    final StringBuilder sb = new StringBuilder();
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

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (NULL.equals(data)) {
      return null;
    }
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));

    return deserialize(q);
  }

  private Node deserialize(final Queue<String> q) {
    final String toRemove = q.remove();
    final List<Node> children = new ArrayList<>();
    final Node root = new Node(Integer.parseInt(toRemove), children);
//    while (!q.isEmpty() && !END.equals(q.peek())) {
    while (!END.equals(q.peek())) {
      children.add(deserialize(q));
    }
    q.remove();
    return root;
  }
}
