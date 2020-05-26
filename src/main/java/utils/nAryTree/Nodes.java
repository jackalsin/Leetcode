package utils.nAryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class Nodes {
  public static Node getNode(final Integer... values) {

    if (values.length == 0) {
      return null;
    }
    final Node root = new Node(values[0], new ArrayList<>());
    final Queue<Node> q = new ArrayDeque<>() {{
      add(root);
    }};
    for (int i = 2; i < values.length; ++i) {
      final Node toRemove = q.remove();
      while (i < values.length && values[i] != null) {
        final Node toAdd = new Node(values[i]);
        if (toRemove.children == null) toRemove.children = new ArrayList<>();
        toRemove.children.add(toAdd);
        q.add(toAdd);
        i++;
      }
    }
    return root;
  }

}
