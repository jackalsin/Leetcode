package definition._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
public final class Nodes {
  private Nodes() {
  }

  public static Node get(final int[]... nodes) {
    final Node root = new Node();
    root.isLeaf = nodes[0][0] == 1;
    root.val = nodes[0][1] == 1;
    final Queue<Node> q = new LinkedList<>();
    for (int i = 1; i < nodes.length; i++) {
      final int[] c = nodes[i];
      if (c == null) {
        q.add(null);
      } else {
        final Node node = new Node();
        node.isLeaf = c[0] == 1;
        node.val = c[1] == 1;
        q.add(node);
      }
    }
    final Queue<Node> parents = new ArrayDeque<>() {{
      add(root);
    }};
    while (!parents.isEmpty()) {
      final int size = parents.size();
      for (int i = 0; i < size; ++i) {
        final Node p = parents.remove();
        if (q.isEmpty()) break;
        p.topLeft = q.remove();
        if (p.topLeft != null) {
          parents.add(p.topLeft);
        }
        p.topRight = q.remove();
        if (p.topRight != null) {
          parents.add(p.topRight);
        }
        p.bottomLeft = q.remove();
        if (p.bottomLeft != null) {
          parents.add(p.bottomLeft);
        }
        p.bottomRight = q.remove();
        if (p.bottomRight != null) {
          parents.add(p.bottomRight);
        }
      }
    }
    return root;
  }
}
