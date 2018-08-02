package interviews.facebook._133_Clone_Graph;

import utils.UndirectedGraphNode;

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
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    final Map<UndirectedGraphNode, UndirectedGraphNode> originalToClones = new HashMap<>();
    return cloneGraph(originalToClones, node);
  }

  private static UndirectedGraphNode cloneGraph(Map<UndirectedGraphNode, UndirectedGraphNode> originalToClones,
                                                UndirectedGraphNode node) {
    if (originalToClones.containsKey(node)) {
      return originalToClones.get(node);
    }

    final UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    originalToClones.put(node, copy);

    for (final UndirectedGraphNode nei : node.neighbors) {
      copy.neighbors.add(cloneGraph(originalToClones, nei));
    }
    return copy;
  }

}
