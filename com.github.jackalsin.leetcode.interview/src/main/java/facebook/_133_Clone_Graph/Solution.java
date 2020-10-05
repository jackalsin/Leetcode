package facebook._133_Clone_Graph;

import utils._133_Clone_Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    final Map<Node, Node> originalToClones = new HashMap<>();
    return cloneGraph(originalToClones, node);
  }

  private static Node cloneGraph(Map<Node, Node> originalToClones,
                                 Node node) {
    if (originalToClones.containsKey(node)) {
      return originalToClones.get(node);
    }

    final Node copy = new Node(node.val, new ArrayList<>());
    originalToClones.put(node, copy);

    for (final Node nei : node.neighbors) {
      copy.neighbors.add(cloneGraph(originalToClones, nei));
    }
    return copy;
  }

}
