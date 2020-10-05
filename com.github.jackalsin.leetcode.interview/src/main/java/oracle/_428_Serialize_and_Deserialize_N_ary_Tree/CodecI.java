package oracle._428_Serialize_and_Deserialize_N_ary_Tree;

import utils.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class CodecI implements Codec {
  private static final String SEP = ",", END = ")";

  public String serialize(Node root) {
    if (root == null) {
      return null;
    }
    final StringBuilder sb = new StringBuilder();
    serialize(sb, root);
    return sb.substring(1);
  }

  private static void serialize(final StringBuilder sb, final Node root) {
    if (root == null) {
      return;
    }
    sb.append(SEP).append(root.val);
    for (final Node n : root.children) {
      serialize(sb, n);
    }
    sb.append(SEP).append(END);
  }

  public Node deserialize(String data) {
    if (data == null) {
      return null;
    }
    final String[] dataArr = data.split(SEP);
    final Queue<String> q = new ArrayDeque<>(Arrays.asList(dataArr));
    return deserialize(q);
  }

  private static Node deserialize(final Queue<String> q) {
    if (q.isEmpty()) {
      return null;
    }
    final String e = q.remove();
    final Node root = new Node();
    root.val = Integer.parseInt(e);
    root.children = new ArrayList<>();
    while (!q.peek().equals(END)) {
      root.children.add(deserialize(q));
    }
    q.remove();
    return root;

  }
}
