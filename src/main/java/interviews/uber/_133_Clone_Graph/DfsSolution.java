package interviews.uber._133_Clone_Graph;

import utils.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

public final class DfsSolution implements Solution {
  private final Map<Integer, UndirectedGraphNode> graph = new HashMap<>();

  @Override
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    if (graph.containsKey(node.label)) {
      return graph.get(node.label);
    }
    final UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    graph.put(newNode.label, newNode);
    for (final UndirectedGraphNode neighbor : node.neighbors) {
      newNode.neighbors.add(cloneGraph(neighbor));
    }
    return newNode;
  }
}
