package interviews.airbnb.lowestCommonAncestors;

import utils.treeNode.Node;

import java.util.ArrayList;
import java.util.List;

public final class LCANArySolutionI implements LCANAryTree {
  @Override
  public Node getLowestCommonAncestor(Node root, Node p, Node q) {
    if (root == null || p == null || q == null) {
      throw new NullPointerException();
    }
    if (p == q) {
      return p;
    }
    if (root == p || root == q) {
      return root;
    }
    final List<Node> result = new ArrayList<>();
    for (final Node c : root.children) {
      final Node res = getLowestCommonAncestor(c, p, q);
      if (res != null) {
        result.add(res);
      }
    }
    if (result.size() == 1) {
      return result.get(0); // one hit
    } else if (result.size() == 2) {
      return root; // 2 hits
    }
    return null;
  }
}
