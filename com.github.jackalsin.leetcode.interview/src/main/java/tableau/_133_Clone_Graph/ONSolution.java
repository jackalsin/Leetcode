package tableau._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final class ONSolution implements Solution {
  private final Map<Node, Node> srcToTgt = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    if (srcToTgt.containsKey(node)) {
      return srcToTgt.get(node);
    }
    final ArrayList<Node> children = new ArrayList<>();
    final Node res = new Node(node.val, children);
    srcToTgt.put(node, res);
    for (final Node c : node.neighbors) {
      children.add(cloneGraph(c));
    }
    return res;
  }
}
