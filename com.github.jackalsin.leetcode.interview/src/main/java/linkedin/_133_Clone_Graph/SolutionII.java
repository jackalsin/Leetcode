package linkedin._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
public final class SolutionII implements Solution {
  @Override
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    final Map<Node, Node> srcToCopy = new HashMap<>();
    return cloneGraph(srcToCopy, node);
  }

  private static Node cloneGraph(final Map<Node, Node> srcToCopy, final Node src) {
    if (srcToCopy.containsKey(src)) {
      return srcToCopy.get(src);
    }
    final Node copy = new Node(src.val, new ArrayList<>());
    srcToCopy.put(src, copy);
    for (final Node srcNei : src.neighbors) {
      copy.neighbors.add(cloneGraph(srcToCopy, srcNei));
    }
    return copy;
  }
}
